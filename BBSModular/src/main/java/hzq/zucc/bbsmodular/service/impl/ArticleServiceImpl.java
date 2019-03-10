package hzq.zucc.bbsmodular.service.impl;

import hzq.zucc.bbsmodular.dao.ArticleRepositoryDao;
import hzq.zucc.bbsmodular.domain.ArticleDto;
import hzq.zucc.bbsmodular.service.ArticleService;
import hzq.zucc.bbsmodular.util.ResultDto;
import hzq.zucc.bbsmodular.util.ResultDtoFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * @Auther: 何圳青
 * @Date: Created in 16:09 2019/3/4
 * @Description:
 * @Modified By:
 */
@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleRepositoryDao articleRepositoryDao;

    private static Date date = new Date();

    @Override
    public ResultDto getAllArticle() {
        List<ArticleDto> result = articleRepositoryDao.findAll();
        return ResultDtoFactory.toAck("获取文章成功", result);
    }

    @Override
    public ResultDto getArticleByAuthor(int authorId) {
        List<ArticleDto> result = articleRepositoryDao.findByUserId(authorId);
        return ResultDtoFactory.toAck("获取文章成功", result);
    }

    @Override
    public ResultDto saveArticle(ArticleDto article) {
        article.setCreateTime(new Timestamp(date.getTime()));
        articleRepositoryDao.save(article);
        return ResultDtoFactory.toAck("保存文章成功");
    }

    @Override
    public ResultDto updateArticle(ArticleDto article) {
        article.setUpdateTime(new Timestamp(date.getTime()));
        articleRepositoryDao.save(article);
        return ResultDtoFactory.toAck("修改文章成功", article);
    }

    @Override
    public ResultDto deleteArticle(int articleId) {
        ArticleDto article = articleRepositoryDao.findByArticleId(articleId);
        article.setDeleteTime(new Timestamp(date.getTime()));
        return ResultDtoFactory.toAck("删除成功", article);
    }

    @Override
    public ResultDto getArticleById(int articleId) {
        return ResultDtoFactory.toAck("获取成功",articleRepositoryDao.findByArticleId(articleId));
    }
}
