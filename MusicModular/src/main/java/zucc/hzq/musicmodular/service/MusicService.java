package zucc.hzq.musicmodular.service;

import zucc.hzq.musicmodular.domain.MusicDto;
import zucc.hzq.musicmodular.util.ResultDto;

/**
 * @Auther: 何圳青
 * @Date: Created in 10:01 2019/2/26
 * @Description:
 * @Modified By:
 */
public interface MusicService {
    public ResultDto getAllMusic();

    public ResultDto getMusicById(int songId);

    public ResultDto getMusicByAuthorId(int userId);

    public ResultDto saveMusic(MusicDto music);

    public ResultDto collectionMusic(int songId);

    public ResultDto dislikeMusic(int songId);
}
