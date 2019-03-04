package zucc.hzq.feign.zcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import zucc.hzq.feign.service.ServiceArticleComment;
import zucc.hzq.feign.util.ResultDto;

/**
 * @Auther: 何圳青
 * @Date: Created in 19:39 2019/3/4
 * @Description:
 * @Modified By:
 */
@ComponentScan(basePackages = "zucc.hzq.feign.service")
@RestController
@CrossOrigin
@RequestMapping("/articlecomment")
public class ArticleCommentController {

    @Autowired
    private ServiceArticleComment serviceArticleComment;

    @RequestMapping("/getcommentbyarticle")
    public ResultDto getCommentByArticle(@RequestBody int articleId){
        return serviceArticleComment.getCommentByArticle(articleId);
    }

    @RequestMapping("/savecomment")
    public ResultDto saveComment(@RequestBody Object articleComment){
        return serviceArticleComment.saveComment(articleComment);
    }

    @RequestMapping("/updatecomment")
    public ResultDto updateComment(@RequestBody Object articleComment){
        return serviceArticleComment.updateComment(articleComment);
    }

    @RequestMapping("/deletecomment")
    public ResultDto deleteComment(@RequestBody int commentId){
        return serviceArticleComment.deleteComment(commentId);
    }

}
