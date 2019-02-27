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
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/login")
    public ResultDto login(HttpServletRequest request){
        UserDto user = new UserDto();

        user.setUserEmail(request.getParameter("user_email"));
        user.setUserPassword(request.getParameter("user_password"));

        return userService.login(user);
    }

//    public ResultDto getUser(HttpServletRequest request){
//
//    }

    @RequestMapping("/register")
    public ResultDto register(@RequestBody UserDto user, HttpServletRequest request){
        return userService.register(user);
    }

    @ResponseBody
    @RequestMapping(value = "/test")
    public boolean test(HttpServletRequest request){
        String email = request.getParameter("user_email");
        System.out.print(email);
        String resule = "aaa";
        return true;
    }
}
