package zucc.hzq.usermodular.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zucc.hzq.usermodular.dao.UserRepositoryDao;
import zucc.hzq.usermodular.domain.UserDto;
import zucc.hzq.usermodular.service.UserService;
import zucc.hzq.usermodular.util.ResultDto;
import zucc.hzq.usermodular.util.ResultDtoFactory;

/**
 * @Auther: 何圳青
 * @Date: Created in 19:44 2019/1/28
 * @Description:
 * @Modified By:
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepositoryDao userRepositoryDao;

    @Override
    public ResultDto login(UserDto user) {
        UserDto returnUser;
        try {
            returnUser = userRepositoryDao.findByUserEmail(user.getUserEmail());
            if (returnUser.getUserPassword().equals(user.getUserPassword())) {
                return ResultDtoFactory.toAck("登录成功", returnUser);
            } else {
                return ResultDtoFactory.toNack("用户名或密码错误");
            }
        } catch (Exception e) {
            System.out.print(e);
            return ResultDtoFactory.toNack("用户不存在");
        }
    }

    @Override
    public ResultDto register(UserDto user) {
        UserDto checkUser;
        try {
            checkUser = userRepositoryDao.findByUserEmail(user.getUserEmail());
            if (checkUser == null) {
                userRepositoryDao.saveAndFlush(user);
                return ResultDtoFactory.toAck("注册成功", userRepositoryDao.findByUserEmail(user.getUserEmail()));
            } else {
                return ResultDtoFactory.toNack("用户已存在");
            }
        } catch (Exception e) {
            System.out.print(e);
            return ResultDtoFactory.toNack("注册失败");
        }
    }


}
