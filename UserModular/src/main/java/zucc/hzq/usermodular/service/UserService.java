package zucc.hzq.usermodular.service;

import zucc.hzq.usermodular.domain.UserDto;
import zucc.hzq.usermodular.util.ResultDto;

/**
 * @Auther: 何圳青
 * @Date: Created in 19:43 2019/1/28
 * @Description:
 * @Modified By:
 */
public interface UserService {
    public ResultDto login(UserDto user);
    public ResultDto register(UserDto user);
}
