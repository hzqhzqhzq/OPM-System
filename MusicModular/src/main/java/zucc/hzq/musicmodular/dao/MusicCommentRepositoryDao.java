package zucc.hzq.musicmodular.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import zucc.hzq.musicmodular.domain.MusicCommentDto;

/**
 * @Auther: 何圳青
 * @Date: Created in 22:06 2019/2/26
 * @Description:
 * @Modified By:
 */
public interface MusicCommentRepositoryDao extends JpaRepository<MusicCommentDto, Long> {
}
