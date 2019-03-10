package hzq.zucc.bbsmodular.dao;

import hzq.zucc.bbsmodular.domain.ArticleDto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @Auther: 何圳青
 * @Date: Created in 16:11 2019/3/4
 * @Description:
 * @Modified By:
 */
public interface ArticleRepositoryDao extends JpaRepository<ArticleDto, Long> {
    List<ArticleDto> findByUserId(int authorId);
    ArticleDto findByArticleId(int articleId);
}
