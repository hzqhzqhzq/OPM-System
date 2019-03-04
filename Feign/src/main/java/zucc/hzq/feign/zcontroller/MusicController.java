package zucc.hzq.feign.zcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import zucc.hzq.feign.service.ServiceMusic;
import zucc.hzq.feign.util.ResultDto;

/**
 * @Auther: 何圳青
 * @Date: Created in 15:21 2019/3/3
 * @Description:
 * @Modified By:
 */
@RestController
@CrossOrigin
@RequestMapping("/music")
public class MusicController {

    @Autowired
    ServiceMusic serviceMusic;

    @RequestMapping("/getallmusic")
    public ResultDto getAllMusic() {
        return serviceMusic.getAllMusic();
    }

    @RequestMapping("/getmusicbyid")
    public ResultDto getMusicById(@RequestBody int songId) {
        return serviceMusic.getMusicById(songId);
    }

    @RequestMapping("/getmusicbyauthor")
    public ResultDto getMusicByAuthor(@RequestBody int authorId) {
        return serviceMusic.getMusicByAuthor(authorId);
    }

    @RequestMapping("/savemusic")
    public ResultDto saveMusic(@RequestBody Object music) {
        return serviceMusic.saveMusic(music);
    }

    @RequestMapping("/collection")
    public ResultDto collectionMusic(@RequestBody int songId) {
        return serviceMusic.collectionMusic(songId);
    }

    @RequestMapping("/dislike")
    public ResultDto dislikeMusic(@RequestBody int songId) {
        return serviceMusic.dislikeMusic(songId);
    }

    @RequestMapping("/deletemusic")
    public ResultDto deleteMusic(@RequestBody int songId) {
        return serviceMusic.deleteMusic(songId);
    }

}
