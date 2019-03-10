package hzq.zucc.bbsmodular.service.impl;

import hzq.zucc.bbsmodular.dao.ArticleCommentRepositoryDao;
import hzq.zucc.bbsmodular.domain.ArticleCommentDto;
import hzq.zucc.bbsmodular.service.ArticleCommentService;
import hzq.zucc.bbsmodular.util.ResultDto;
import hzq.zucc.bbsmodular.util.ResultDtoFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Optional;

/**
 * @Auther: 何圳青
 * @Date: Created in 16:09 2019/3/4
 * @Description:
 * @Modified By:
 */
@Service
public class ArticleCommentServiceImpl implements ArticleCommentService {

    @Autowired
    private ArticleCommentRepositoryDao articleCommentRepositoryDao;

    private static Date date = new Date();

    @Override
    public ResultDto getCommentByArticle(int articleId) {
        return ResultDtoFactory.toAck("获取成功", articleCommentRepositoryDao.findAllByDeleteTimeIsNullAndArticleId(articleId));
    }

    @Override
    public ResultDto saveComment(ArticleCommentDto articleComment) {
        articleComment.setCreateTime(new Timestamp(date.getTime()));
        articleCommentRepositoryDao.save(articleComment);
        return ResultDtoFactory.toAck("保存成功");
    }

    @Override
    public ResultDto updateComment(ArticleCommentDto articleComment) {
        articleComment.setUpdateTime(new Timestamp(date.getTime()));
        articleCommentRepositoryDao.save(articleComment);
        return ResultDtoFactory.toAck("修改成功", articleComment);
    }

    @Override
    public ResultDto deleteComment(int commentId) {
        ArticleCommentDto articleComment = articleCommentRepositoryDao.findByCommentId(commentId);
        articleComment.setDeleteTime(new Timestamp(date.getTime()));
        articleCommentRepositoryDao.save(articleComment);
        return ResultDtoFactory.toAck("删除成功");
    }
}
