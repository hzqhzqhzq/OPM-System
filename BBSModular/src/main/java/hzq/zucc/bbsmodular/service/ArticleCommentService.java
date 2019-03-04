package hzq.zucc.bbsmodular.service;

import hzq.zucc.bbsmodular.domain.ArticleCommentDto;
import hzq.zucc.bbsmodular.util.ResultDto;

/**
 * @Auther: 何圳青
 * @Date: Created in 16:08 2019/3/4
 * @Description:
 * @Modified By:
 */
public interface ArticleCommentService {
    ResultDto getCommentByArticle(int articleId);
    ResultDto saveComment(ArticleCommentDto articleComment);
    ResultDto updateComment(ArticleCommentDto articleComment);
    ResultDto deleteComment(int commentId);
}
