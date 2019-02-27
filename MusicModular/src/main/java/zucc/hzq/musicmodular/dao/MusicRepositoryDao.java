package zucc.hzq.musicmodular.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import zucc.hzq.musicmodular.domain.MusicDto;

/**
 * @Auther: 何圳青
 * @Date: Created in 10:05 2019/2/26
 * @Description:
 * @Modified By:
 */
public interface MusicRepositoryDao extends JpaRepository<MusicDto, Long> {
    public MusicDto findByAuthorId(int authorId);
}
