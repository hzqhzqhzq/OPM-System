package zucc.hzq.feign.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import zucc.hzq.feign.util.ResultDto;

/**
 * @Auther: 何圳青
 * @Date: Created in 19:40 2019/3/4
 * @Description:
 * @Modified By:
 */
@FeignClient(value = "bbsmodular")
public interface ServiceArticle {

    @RequestMapping("/getallarticle")
    ResultDto getAllArticle();

    @RequestMapping("/getarticlebyauthor")
    ResultDto getArticleByAuthor(@RequestParam("user_id") int authorId);

    @RequestMapping("/savearticle")
    ResultDto saveArticle(@RequestBody Object article);

    @RequestMapping("/updatearticle")
    ResultDto updateArticle(@RequestBody Object article);

    @RequestMapping("/deletearticle")
    ResultDto deleteArticle(@RequestParam("user_id") int articleId);

    @RequestMapping("/getarticlebyid")
    ResultDto getArticleById(@RequestParam("article_id") int articleId);

    @RequestMapping("/addreply")
    ResultDto addReply(@RequestParam("article_id") int articleId);

    @RequestMapping("/searcharticle")
    ResultDto searchArticle(@RequestParam("seacher") String searcher);
}
