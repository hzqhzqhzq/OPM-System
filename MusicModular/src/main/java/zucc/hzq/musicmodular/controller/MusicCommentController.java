package zucc.hzq.musicmodular.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import zucc.hzq.musicmodular.domain.MusicCommentDto;
import zucc.hzq.musicmodular.service.MusicCommentService;
import zucc.hzq.musicmodular.util.ResultDto;

/**
 * @Auther: 何圳青
 * @Date: Created in 17:17 2019/2/26
 * @Description:
 * @Modified By:
 */
@RestController
@CrossOrigin
//@RequestMapping("/musiccomment")
public class MusicCommentController {

    @Autowired
    private MusicCommentService musicCommentService;

    @RequestMapping("/getcommentbymusic")
    public ResultDto getCommentByMusic(@RequestBody int songId){
        return musicCommentService.getMusicCommentByMusicId(songId);
    }

    @RequestMapping("/savecomment")
    public ResultDto saveComment(@RequestBody MusicCommentDto musicComment) {
        return musicCommentService.saveComment(musicComment);
    }

    @RequestMapping("/deletecomment")
    public ResultDto deleteComment(@RequestBody int songId) {
        return musicCommentService.deleteComment(songId);
    }

    @RequestMapping("/updatecomment")
    public ResultDto updateComment(@RequestBody MusicCommentDto musicComment) {
        return musicCommentService.updateComment(musicComment);
    }

}
