package zucc.hzq.musicmodular.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import zucc.hzq.musicmodular.domain.MusicDto;
import zucc.hzq.musicmodular.service.MusicService;
import zucc.hzq.musicmodular.util.ResultDto;
import zucc.hzq.musicmodular.util.ResultDtoFactory;

/**
 * @Auther: zhenqinghe
 * @Date: Created in 10:17 AM 2/19/2019
 * @Description:
 * @Modified By:
 */

@RestController
@CrossOrigin
//@RequestMapping("/music")
public class MusicController {

    @Autowired
    private MusicService musicService;

    @RequestMapping("/getallmusic")
    public ResultDto getAllMusic() {
        return musicService.getAllMusic();
    }

    @RequestMapping("/getmusicbyid")
    public ResultDto getMusicById(@RequestParam(value = "song_id") int songId) {
        return musicService.getMusicById(songId);
    }

    @RequestMapping("/getmusicbyauthor")
    public ResultDto getMusicByAuthor(@RequestParam(value = "user_id") int authorId) {
        return musicService.getMusicByAuthorId(authorId);
    }

    @RequestMapping(value = "/upfile", method = RequestMethod.POST)
    public ResultDto upMusic(@RequestParam("file")MultipartFile file) {
        return musicService.upFile(file);
    }

    @RequestMapping("/savemusic")
    public ResultDto saveMusic(@RequestBody MusicDto music) {
        return musicService.saveMusic(music);
    }

    @RequestMapping("/collection")
    public ResultDto collectionMusic(@RequestParam(value = "song_id") int songId) {
        return musicService.collectionMusic(songId);
    }

    @RequestMapping("/dislike")
    public ResultDto dislikeMusic(@RequestParam(value = "song_id") int songId) {
        return musicService.dislikeMusic(songId);
    }

    @RequestMapping("/deletemusic")
    public ResultDto deleteMusic(@RequestParam(value = "song_id") int songId) {
        return musicService.deleteMusic(songId);
    }

    @RequestMapping("/getbestmusic")
    public ResultDto getBestMusic() {
        return musicService.getBestMusic();
    }

}
