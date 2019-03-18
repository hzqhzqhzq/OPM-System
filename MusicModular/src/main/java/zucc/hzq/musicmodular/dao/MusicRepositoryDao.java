package zucc.hzq.musicmodular.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import zucc.hzq.musicmodular.domain.MusicDto;

import java.util.List;

/**
 * @Auther: 何圳青
 * @Date: Created in 10:05 2019/2/26
 * @Description:
 * @Modified By:
 */
public interface MusicRepositoryDao extends JpaRepository<MusicDto, Long> {
    List<MusicDto> findByAuthorIdAndDeleteTimeIsNull(int authorId);

    MusicDto findBySongId(int songId);

    List<MusicDto> findAllByDeleteTimeIsNull();

    @Query(value = "select o.* from song_info o order by collection desc limit 3", nativeQuery = true)
    @Modifying
    List<MusicDto> findOrderByName();

}
