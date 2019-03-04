package zucc.hzq.musicmodular.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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
    public ResultDto getMusicById(@RequestBody int songId) {
        return musicService.getMusicById(songId);
    }

    @RequestMapping("/getmusicbyauthor")
    public ResultDto getMusicByAuthor(@RequestBody int authorId) {
        return musicService.getMusicByAuthorId(authorId);
    }

    @RequestMapping("/savemusic")
    public ResultDto saveMusic(@RequestBody MusicDto music) {
        return musicService.saveMusic(music);
    }

    @RequestMapping("/collection")
    public ResultDto collectionMusic(@RequestBody int songId) {
        return musicService.collectionMusic(songId);
    }

    @RequestMapping("/dislike")
    public ResultDto dislikeMusic(@RequestBody int songId) {
        return musicService.dislikeMusic(songId);
    }

    @RequestMapping("/deletemusic")
    public ResultDto deleteMusic(@RequestBody int songId) {
        return musicService.deleteMusic(songId);
    }

}
