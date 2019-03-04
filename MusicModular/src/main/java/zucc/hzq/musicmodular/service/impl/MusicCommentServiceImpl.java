package zucc.hzq.musicmodular.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zucc.hzq.musicmodular.dao.MusicCommentRepositoryDao;
import zucc.hzq.musicmodular.domain.MusicCommentDto;
import zucc.hzq.musicmodular.service.MusicCommentService;
import zucc.hzq.musicmodular.util.ResultDto;
import zucc.hzq.musicmodular.util.ResultDtoFactory;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Optional;

/**
 * @Auther: 何圳青
 * @Date: Created in 22:05 2019/2/26
 * @Description:
 * @Modified By:
 */
@Service
public class MusicCommentServiceImpl implements MusicCommentService {
    private static Date date = new Date();

    @Autowired
    private MusicCommentRepositoryDao musicCommentRepositoryDao;

    @Override
    public ResultDto getMusicCommentByMusicId(int songId) {
        return ResultDtoFactory.toAck("评论搜索成功！", musicCommentRepositoryDao.findById(new Long((long) songId)));
    }

    @Override
    public ResultDto saveComment(MusicCommentDto musicCommentDto) {
        musicCommentDto.setCreateTime(new Timestamp(date.getTime()));
        musicCommentRepositoryDao.save(musicCommentDto);
        return ResultDtoFactory.toAck("保存评论成功");
    }

    @Override
    public ResultDto deleteComment(int commentId) {
        Optional<MusicCommentDto> musicComment = musicCommentRepositoryDao.findById(new Long((long)commentId));
        if (musicComment.get() == null) {
            return ResultDtoFactory.toNack("没有该条评论信息");
        } else {
            musicComment.get().setDeleteTime(new Timestamp(date.getTime()));
            musicCommentRepositoryDao.save(musicComment.get());
            return ResultDtoFactory.toAck("删除评论成功");
        }
    }

    @Override
    public ResultDto updateComment(MusicCommentDto musicComment) {
        musicComment.setUpdateTime(new Timestamp(date.getTime()));
        musicCommentRepositoryDao.save(musicComment);
        return ResultDtoFactory.toAck("修改评论成功", musicComment);
    }
}
