package zucc.hzq.musicmodular.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zucc.hzq.musicmodular.dao.MusicCommentRepositoryDao;
import zucc.hzq.musicmodular.domain.MusicCommentDto;
import zucc.hzq.musicmodular.service.MusicCommentService;
import zucc.hzq.musicmodular.util.ResultDto;
import zucc.hzq.musicmodular.util.ResultDtoFactory;

/**
 * @Auther: 何圳青
 * @Date: Created in 22:05 2019/2/26
 * @Description:
 * @Modified By:
 */
@Service
public class MusicCommentServiceImpl implements MusicCommentService {

    @Autowired
    private MusicCommentRepositoryDao musicCommentRepositoryDao;

    @Override
    public ResultDto getMusicCommentByMusicId(int songId) {
        return ResultDtoFactory.toAck("评论搜索成功！", musicCommentRepositoryDao.findById(new Long((long) songId)));
    }

    @Override
    public ResultDto saveComment(MusicCommentDto musicCommentDto) {
        musicCommentRepositoryDao.save(musicCommentDto);
        return null;
    }

    @Override
    public ResultDto deleteComment(int commentId) {
        return null;
    }
}
