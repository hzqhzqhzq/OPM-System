package zucc.hzq.musicmodular.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zucc.hzq.musicmodular.dao.MusicRepositoryDao;
import zucc.hzq.musicmodular.domain.MusicDto;
import zucc.hzq.musicmodular.service.MusicService;
import zucc.hzq.musicmodular.util.ResultDto;
import zucc.hzq.musicmodular.util.ResultDtoFactory;

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

    @Override
    public ResultDto getAllMusic() {
        List<MusicDto> returnMusic = musicRepositoryDao.findAll();

        return ResultDtoFactory.toAck("所有音乐获取成功！", returnMusic);
    }

    @Override
    public ResultDto getMusicById(int songId) {
        return ResultDtoFactory.toAck("获取音乐成功！", musicRepositoryDao.findById(new Long((long)songId)));
    }

    @Override
    public ResultDto getMusicByAuthorId(int userId) {
        return ResultDtoFactory.toAck("获取音乐成功！", musicRepositoryDao.findByAuthorId(userId));
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
}
