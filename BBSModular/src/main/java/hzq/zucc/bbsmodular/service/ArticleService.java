package hzq.zucc.bbsmodular.service;

import hzq.zucc.bbsmodular.domain.ArticleDto;
import hzq.zucc.bbsmodular.util.ResultDto;

/**
 * @Auther: 何圳青
 * @Date: Created in 16:08 2019/3/4
 * @Description:
 * @Modified By:
 */
public interface ArticleService {
    ResultDto getAllArticle();
    ResultDto getArticleByAuthor(int authorId);
    ResultDto saveArticle(ArticleDto article);
    ResultDto updateArticle(ArticleDto article);
    ResultDto deleteArticle(int articleId);
    ResultDto getArticleById(int articleId);

    ResultDto addReply(int articleId);
}
