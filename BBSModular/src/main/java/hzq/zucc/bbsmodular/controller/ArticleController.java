package hzq.zucc.bbsmodular.controller;

import hzq.zucc.bbsmodular.domain.ArticleDto;
import hzq.zucc.bbsmodular.service.ArticleService;
import hzq.zucc.bbsmodular.util.ResultDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: 何圳青
 * @Date: Created in 19:18 2019/3/4
 * @Description:
 * @Modified By:
 */
@RestController
@CrossOrigin
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @RequestMapping("/getallarticle")
    public ResultDto getAllArticle(){
        return articleService.getAllArticle();
    }

    @RequestMapping("/getarticlebyauthor")
    public ResultDto getArticleByAuthor(@RequestBody int authorId){
        return articleService.getArticleByAuthor(authorId);
    }

    @RequestMapping("/savearticle")
    public ResultDto saveArticle(@RequestBody ArticleDto article){
        return articleService.saveArticle(article);
    }

    @RequestMapping("/updatearticle")
    public ResultDto updateArticle(@RequestBody ArticleDto article){
        return articleService.updateArticle(article);
    }

    @RequestMapping("/deletearticle")
    public ResultDto deleteArticle(@RequestBody int articleId){
        return articleService.deleteArticle(articleId);
    }
}
