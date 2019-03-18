package zucc.hzq.feign.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
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
    ResultDto getMusicById(@RequestParam(value = "song_id") int songId);

    @RequestMapping("/getmusicbyauthor")
    ResultDto getMusicByAuthor(@RequestParam(value = "user_id") int authorId);

    @RequestMapping("/savemusic")
    ResultDto saveMusic(@RequestBody Object music);

    @RequestMapping(value = "/upfile", method = RequestMethod.POST)
    ResultDto upFile(@RequestParam("file") MultipartFile file);

    @RequestMapping("/collection")
    ResultDto collectionMusic(@RequestParam(value = "song_id") int songId);

    @RequestMapping("/dislike")
    ResultDto dislikeMusic(@RequestParam(value = "song_id") int songId);

    @RequestMapping("/deletemusic")
    ResultDto deleteMusic(@RequestParam(value = "song_id") int songId);

    @RequestMapping("/getbestmusic")
    ResultDto getBestMusic();
}
