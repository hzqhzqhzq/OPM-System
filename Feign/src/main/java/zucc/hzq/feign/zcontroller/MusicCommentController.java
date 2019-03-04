package zucc.hzq.feign.zcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import zucc.hzq.feign.service.ServiceMusicComment;
import zucc.hzq.feign.util.ResultDto;

/**
 * @Auther: 何圳青
 * @Date: Created in 15:37 2019/3/3
 * @Description:
 * @Modified By:
 */
@RestController
@CrossOrigin
@RequestMapping("/musiccomment")
public class MusicCommentController {

    @Autowired
    ServiceMusicComment serviceMusicComment;

    @RequestMapping("/getcommentbymusic")
    public ResultDto getCommentByMusic(@RequestBody int songId){
        return serviceMusicComment.getCommentByMusic(songId);
    }

    @RequestMapping("/savecomment")
    public ResultDto saveComment(@RequestBody Object musicComment) {
        return serviceMusicComment.saveComment(musicComment);
    }

    @RequestMapping("/deletecomment")
    public ResultDto deleteComment(@RequestBody int songId) {
        return serviceMusicComment.deleteComment(songId);
    }

    @RequestMapping("/updatecomment")
    public ResultDto updateComment(@RequestBody Object musicComment) {
        return serviceMusicComment.updateComment(musicComment);
    }
}
