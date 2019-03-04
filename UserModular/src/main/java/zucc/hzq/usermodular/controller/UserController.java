package zucc.hzq.usermodular.controller;

        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Controller;
        import org.springframework.web.bind.annotation.*;
        import zucc.hzq.usermodular.domain.UserDto;
        import zucc.hzq.usermodular.service.UserService;
        import zucc.hzq.usermodular.util.ResultDto;

        import javax.servlet.http.HttpServletRequest;

/**
 * @Auther: 何圳青
 * @Date: Created in 14:51 2019/1/28
 * @Description:
 * @Modified By:
 */
@RestController
@CrossOrigin
//@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/login")
    public ResultDto login(@RequestParam("user_email") String email, @RequestParam("user_password")String pwd){
        UserDto user = new UserDto();

        user.setUserEmail(email);
        user.setUserPassword(pwd);

        return userService.login(user);
    }

    @RequestMapping("/getuserinfo")
    public ResultDto getUser(@RequestParam("user_email") String email){
        return userService.getUserInfo(email);
    }

    @RequestMapping("/register")
    public ResultDto register(@RequestBody UserDto user){
        return userService.register(user);
    }

    @RequestMapping("/updateuser")
    public ResultDto updateUser(@RequestBody UserDto user){
        return userService.updateUser(user);
    }

    @RequestMapping("/deleteuser")
    public ResultDto daleteUser(@RequestBody String email){
        return userService.deleteUser(email);
    }

}
