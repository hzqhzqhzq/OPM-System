package zucc.hzq.feign.zcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
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
    public ResultDto getMusicById(@RequestParam(value = "song_id") int song_id) {
        return serviceMusic.getMusicById(song_id);
    }

    @RequestMapping("/getmusicbyauthor")
    public ResultDto getMusicByAuthor(@RequestParam(value = "user_id") int user_id) {
        return serviceMusic.getMusicByAuthor(user_id);
    }

    @RequestMapping("/savemusic")
    public ResultDto saveMusic(@RequestBody Object music) {
        return serviceMusic.saveMusic(music);
    }

    @RequestMapping(value = "/upfile", method = RequestMethod.POST)
    public ResultDto upFile(@RequestParam("file") MultipartFile file) {
        return serviceMusic.upFile(file);
    }

    @RequestMapping("/collection")
    public ResultDto collectionMusic(@RequestParam(value = "song_id") int song_id) {
        return serviceMusic.collectionMusic(song_id);
    }

    @RequestMapping("/dislike")
    public ResultDto dislikeMusic(@RequestParam(value = "song_id") int song_id) {
        return serviceMusic.dislikeMusic(song_id);
    }

    @RequestMapping("/deletemusic")
    public ResultDto deleteMusic(@RequestParam(value = "song_id") int songId) {
        return serviceMusic.deleteMusic(songId);
    }

    @RequestMapping("/getbestmusic")
    public ResultDto getBestMusic() {
        return serviceMusic.getBestMusic();
    }

}
