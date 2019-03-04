package zucc.hzq.feign.zcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.*;
import zucc.hzq.feign.service.ServiceUser;
import zucc.hzq.feign.util.ResultDto;

/**
 * @Auther: 何圳青
 * @Date: Created in 10:33 2019/3/2
 * @Description:
 * @Modified By:
 */
@ComponentScan(basePackages = "zucc.hzq.feign.service")
@RestController
@CrossOrigin
public class UserController {

    @Autowired
    ServiceUser serviceUser;

    @PostMapping(value = "/user/login")
    public ResultDto login(@RequestParam("user_email") String email, @RequestParam("user_password") String pwd) {
        return serviceUser.userLogin(email, pwd);
    }

    @PostMapping(value = "/user/register")
    public ResultDto register(@RequestBody Object user) {
        return serviceUser.userRegister(user);
    }

    @PostMapping("/user/getuserinfo")
    public ResultDto getUserInfo(@RequestBody String user_email) {
        return serviceUser.getUserInfo(user_email);
    }

    @PostMapping("/user/updateuser")
    public ResultDto updateUser(@RequestBody Object user) {
        return serviceUser.updateUser(user);
    }

    @PostMapping("/user/deleteuser")
    public ResultDto deleteUser(@RequestBody String user_email) {
        return serviceUser.deleteUser(user_email);
    }

}
