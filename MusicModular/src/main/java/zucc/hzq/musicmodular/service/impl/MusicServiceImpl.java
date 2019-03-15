package zucc.hzq.musicmodular.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import zucc.hzq.musicmodular.dao.MusicRepositoryDao;
import zucc.hzq.musicmodular.domain.MusicDto;
import zucc.hzq.musicmodular.service.MusicService;
import zucc.hzq.musicmodular.util.ResultDto;
import zucc.hzq.musicmodular.util.ResultDtoFactory;

import java.io.File;
import java.io.IOException;
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
        MusicDto music = musicRepositoryDao.findBySongId(songId);
        if (music == null){
            return ResultDtoFactory.toNack("没有该音乐");
        } else {
            return ResultDtoFactory.toAck("获取音乐成功！", music);
        }
    }

    @Override
    public ResultDto getMusicByAuthorId(int userId) {
        List<MusicDto> music = musicRepositoryDao.findByAuthorId(userId);
        if (music == null){
            return ResultDtoFactory.toNack("没有该音乐");
        } else {
            return ResultDtoFactory.toAck("获取音乐成功！", music);
        }
    }

    @Override
    public ResultDto saveMusic(MusicDto music) {
        music.setCreateTime(new Timestamp(date.getTime()));
        musicRepositoryDao.save(music);
        return ResultDtoFactory.toAck("保存音乐成功");
    }

    @Override
    public ResultDto collectionMusic(int songId) {
        MusicDto music = musicRepositoryDao.findBySongId(songId);
        int collection = music.getCollection();
        music.setCollection(collection + 1);
        musicRepositoryDao.save(music);
        return ResultDtoFactory.toAck("修改成功！", music);
    }

    @Override
    public ResultDto dislikeMusic(int songId) {
        MusicDto music = musicRepositoryDao.findBySongId(songId);
        int dislike = music.getDislike();
        music.setDislike(dislike + 1);
        musicRepositoryDao.save(music);
        return ResultDtoFactory.toAck("修改成功！", music);
    }

    @Override
    public ResultDto deleteMusic(int songId) {
        MusicDto music = musicRepositoryDao.findBySongId(songId);
        music.setDeleteTime(new Timestamp(date.getTime()));
        musicRepositoryDao.save(music);
        return ResultDtoFactory.toAck("删除成功");
    }

    @Override
    public ResultDto upFile(MultipartFile file) {
        String fileName = file.getOriginalFilename();
//        String path = "C:/IDEAWorkspace/UI/FriendFinder/music/";
//        String path = "/home/workspace/web_index/music/";
        String path = "D:/myworkspace/test_UI/music/";
        System.out.println(fileName);
        File newFile = new File(path + fileName);
        try {
            file.transferTo(newFile);
            return ResultDtoFactory.toAck("上传成功");
        } catch (IOException e) {
            e.printStackTrace();
            return ResultDtoFactory.toNack("上传失败");
        }
    }

    @Override
    public ResultDto getBestMusic() {
        List<MusicDto> result = musicRepositoryDao.findOrderByName();
        for (int i=0; i<result.size(); i++) {
            for (int j=0; j<(result.size()-i-1); j++) {
                if ((result.get(j).getCollection() - result.get(j).getDislike()) < (result.get(j+1).getCollection() - result.get(j+1).getDislike())) {
                    result.add(j, result.get(j+1));
                    result.add(j+2, result.get(j+1));
                    result.remove(j+1);
                    result.remove(j+2);
                }
            }
        }
        return ResultDtoFactory.toAck("获取成功", result);
    }
}
