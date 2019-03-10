package zucc.hzq.musicmodular.dao;

import org.hibernate.validator.constraints.CreditCardNumber;
import org.springframework.data.jpa.repository.JpaRepository;
import zucc.hzq.musicmodular.domain.MusicCommentDto;
import zucc.hzq.musicmodular.util.ResultDto;

import java.util.List;

/**
 * @Auther: 何圳青
 * @Date: Created in 22:06 2019/2/26
 * @Description:
 * @Modified By:
 */
public interface MusicCommentRepositoryDao extends JpaRepository<MusicCommentDto, Long> {
    List<MusicCommentDto> findByMusicId(int musicId);
    MusicCommentDto findByCommentId(int commentId);
}
