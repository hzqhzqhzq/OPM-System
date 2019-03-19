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
    List<ArticleDto> findAllByUserIdAndDeleteTimeIsNull(int authorId);
    List<ArticleDto> findAllByDeleteTimeIsNull();
    ArticleDto findByArticleId(int articleId);
    List<ArticleDto> findAllByTitleLikeOrContentLikeOrUserNameLikeOrTypeLike(String title, String content, String userName, String type);
}
