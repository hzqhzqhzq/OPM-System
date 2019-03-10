package zucc.hzq.feign.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import zucc.hzq.feign.util.ResultDto;

/**
 * @Auther: 何圳青
 * @Date: Created in 19:41 2019/3/4
 * @Description:
 * @Modified By:
 */
@FeignClient(value = "bbsmodular")
public interface ServiceArticleComment {

    @RequestMapping("/getcommentbyarticle")
    ResultDto getCommentByArticle(@RequestParam("article_id") int articleId);

    @RequestMapping("/savecomment")
    ResultDto saveComment(@RequestBody Object articleComment);

    @RequestMapping("/updatecomment")
    ResultDto updateComment(@RequestBody Object articleComment);

    @RequestMapping("/deletecomment")
    ResultDto deleteComment(@RequestParam("comment_id") int commentId);
}
