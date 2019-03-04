package zucc.hzq.feign.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import zucc.hzq.feign.util.ResultDto;

/**
 * @Auther: 何圳青
 * @Date: Created in 15:21 2019/3/3
 * @Description:
 * @Modified By:
 */
@FeignClient(value = "musicmodular")
public interface ServiceMusic {

    @RequestMapping("/getallmusic")
    ResultDto getAllMusic();

    @RequestMapping("/getmusicbyid")
    ResultDto getMusicById(@RequestBody int songId);

    @RequestMapping("/getmusicbyauthor")
    ResultDto getMusicByAuthor(@RequestBody int authorId);

    @RequestMapping("/savemusic")
    ResultDto saveMusic(@RequestBody Object music);

    @RequestMapping("/collection")
    ResultDto collectionMusic(@RequestBody int songId);

    @RequestMapping("/dislike")
    ResultDto dislikeMusic(@RequestBody int songId);

    @RequestMapping("/deletemusic")
    ResultDto deleteMusic(@RequestBody int songId);
}
