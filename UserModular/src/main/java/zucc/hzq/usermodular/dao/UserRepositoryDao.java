package zucc.hzq.usermodular.dao;

        import org.springframework.data.jpa.repository.JpaRepository;
        import zucc.hzq.usermodular.domain.UserDto;

/**
 * @Auther: 何圳青
 * @Date: Created in 21:50 2019/1/28
 * @Description:
 * @Modified By:
 */
public interface UserRepositoryDao extends JpaRepository<UserDto, Long> {
    public UserDto findByUserEmail(String Email);
}
