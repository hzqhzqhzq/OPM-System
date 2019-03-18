package hzq.zucc.bbsmodular.controller;

import hzq.zucc.bbsmodular.domain.ArticleDto;
import hzq.zucc.bbsmodular.service.ArticleService;
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
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @RequestMapping("/getallarticle")
    public ResultDto getAllArticle(){
        return articleService.getAllArticle();
    }

    @RequestMapping("/getarticlebyauthor")
    public ResultDto getArticleByAuthor(@RequestParam("user_id") int authorId){
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
    public ResultDto deleteArticle(@RequestParam("user_id") int articleId){
        return articleService.deleteArticle(articleId);
    }

    @RequestMapping("/getarticlebyid")
    public ResultDto getArticleById(@RequestParam("article_id") int articleId) {
        return articleService.getArticleById(articleId);
    }

    @RequestMapping("/addreply")
    public ResultDto addReply(@RequestParam("article_id") int articleId) {
        return articleService.addReply(articleId);
    }

    @RequestMapping("/searcharticle")
    public ResultDto search(@RequestParam("seacher") String seacher) {
        return articleService.searchArticle(seacher);
    }
}
