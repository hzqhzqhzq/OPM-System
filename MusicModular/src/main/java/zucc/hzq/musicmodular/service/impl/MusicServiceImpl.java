package zucc.hzq.musicmodular.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zucc.hzq.musicmodular.dao.MusicRepositoryDao;
import zucc.hzq.musicmodular.domain.MusicDto;
import zucc.hzq.musicmodular.service.MusicService;
import zucc.hzq.musicmodular.util.ResultDto;
import zucc.hzq.musicmodular.util.ResultDtoFactory;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * @Auther: 何圳青
 * @Date: Created in 10:02 2019/2/26
 * @Description:
 * @Modified By:
 */
@Service
public class MusicServiceImpl implements MusicService {
    @Autowired
    private MusicRepositoryDao musicRepositoryDao;

    private static Date date = new Date();

    @Override
    public ResultDto getAllMusic() {
        List<MusicDto> returnMusic = musicRepositoryDao.findAll();

        return ResultDtoFactory.toAck("所有音乐获取成功！", returnMusic);
    }

    @Override
    public ResultDto getMusicById(int songId) {
        Optional<MusicDto> music = musicRepositoryDao.findById(new Long((long)songId));
        if (music == null){
            return ResultDtoFactory.toNack("没有该音乐");
        } else {
            return ResultDtoFactory.toAck("获取音乐成功！", music);
        }
    }

    @Override
    public ResultDto getMusicByAuthorId(int userId) {
        Optional<MusicDto> music = musicRepositoryDao.findById(new Long((long)userId));
        if (music == null){
            return ResultDtoFactory.toNack("没有该音乐");
        } else {
            return ResultDtoFactory.toAck("获取音乐成功！", music);
        }
    }

    @Override
    public ResultDto saveMusic(MusicDto music) {
        musicRepositoryDao.save(music);
        return ResultDtoFactory.toAck("保存音乐成功！");
    }

    @Override
    public ResultDto collectionMusic(int songId) {
        Optional<MusicDto> music = musicRepositoryDao.findById(new Long((long)songId));
        int collection = music.get().getCollection();
        music.get().setCollection(collection + 1);
        musicRepositoryDao.save(music.get());
        return ResultDtoFactory.toAck("修改成功！", music.get());
    }

    @Override
    public ResultDto dislikeMusic(int songId) {
        Optional<MusicDto> music = musicRepositoryDao.findById(new Long((long)songId));
        int dislike = music.get().getDislike();
        music.get().setCollection(dislike + 1);
        musicRepositoryDao.save(music.get());
        return ResultDtoFactory.toAck("修改成功！", music.get());
    }

    @Override
    public ResultDto deleteMusic(int songId) {
        Optional<MusicDto> music = musicRepositoryDao.findById(new Long((long)songId));
        music.get().setDeleteTime(new Timestamp(date.getTime()));
        musicRepositoryDao.save(music.get());
        return ResultDtoFactory.toAck("删除成功");
    }
}
