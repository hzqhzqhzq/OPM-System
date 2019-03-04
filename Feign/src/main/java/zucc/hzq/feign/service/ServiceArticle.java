package zucc.hzq.feign.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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
    ResultDto getArticleByAuthor(@RequestBody int authorId);
    @RequestMapping("/savearticle")
    ResultDto saveArticle(@RequestBody Object article);

    @RequestMapping("/updatearticle")
    ResultDto updateArticle(@RequestBody Object article);

    @RequestMapping("/deletearticle")
    ResultDto deleteArticle(@RequestBody int articleId);

}
