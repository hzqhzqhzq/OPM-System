package hzq.zucc.bbsmodular.controller;

import hzq.zucc.bbsmodular.domain.ArticleCommentDto;
import hzq.zucc.bbsmodular.service.ArticleCommentService;
import hzq.zucc.bbsmodular.util.ResultDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Auther: 何圳青
 * @Date: Created in 19:18 2019/3/4
 * @Description:
 * @Modified By:
 */
@RestController
@CrossOrigin
public class ArticleCommentController {

    @Autowired
    private ArticleCommentService articleCommentService;

    @RequestMapping("/getcommentbyarticle")
    public ResultDto getCommentByArticle(@RequestParam("article_id") int articleId){
        return articleCommentService.getCommentByArticle(articleId);
    }

    @RequestMapping("/savecomment")
    public ResultDto saveComment(@RequestBody ArticleCommentDto articleComment){
        return articleCommentService.saveComment(articleComment);
    }

    @RequestMapping("/updatecomment")
    public ResultDto updateComment(@RequestBody ArticleCommentDto articleComment){
        return articleCommentService.updateComment(articleComment);
    }

    @RequestMapping("/deletecomment")
    public ResultDto deleteComment(@RequestParam("comment_id") int commentId){
        return articleCommentService.deleteComment(commentId);
    }

}
