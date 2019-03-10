package zucc.hzq.feign.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import zucc.hzq.feign.util.ResultDto;

/**
 * @Auther: 何圳青
 * @Date: Created in 15:34 2019/3/3
 * @Description:
 * @Modified By:
 */
@FeignClient(value = "musicmodular")
public interface ServiceMusicComment {

    @RequestMapping("/getcommentbymusic")
    public ResultDto getCommentByMusic(@RequestParam("song_id") int songId);

    @RequestMapping("/savecomment")
    public ResultDto saveComment(@RequestBody Object musicComment);

    @RequestMapping("/deletecomment")
    public ResultDto deleteComment(@RequestBody int songId);

    @RequestMapping("/updatecomment")
    public ResultDto updateComment(@RequestBody Object musicComment);
}
