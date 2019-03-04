package zucc.hzq.feign.zcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import zucc.hzq.feign.service.ServiceArticle;
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
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    private ServiceArticle serviceArticle;

    @RequestMapping("/getallarticle")
    public ResultDto getAllArticle(){
        return serviceArticle.getAllArticle();
    }

    @RequestMapping("/getarticlebyauthor")
    public ResultDto getArticleByAuthor(@RequestBody int authorId){
        return serviceArticle.getArticleByAuthor(authorId);
    }

    @RequestMapping("/savearticle")
    public ResultDto saveArticle(@RequestBody Object article){
        return serviceArticle.saveArticle(article);
    }

    @RequestMapping("/updatearticle")
    public ResultDto updateArticle(@RequestBody Object article){
        return serviceArticle.updateArticle(article);
    }

    @RequestMapping("/deletearticle")
    public ResultDto deleteArticle(@RequestBody int articleId){
        return serviceArticle.deleteArticle(articleId);
    }
}
