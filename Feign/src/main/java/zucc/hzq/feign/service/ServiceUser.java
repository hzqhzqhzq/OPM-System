package zucc.hzq.feign.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import zucc.hzq.feign.util.ResultDto;

/**
 * @Auther: 何圳青
 * @Date: Created in 10:29 2019/3/2
 * @Description:
 * @Modified By:
 */
@FeignClient(value = "usermodular")
public interface ServiceUser {
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    ResultDto userLogin(@RequestParam(value = "user_email")String email, @RequestParam(value = "user_password")String pwd);

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    ResultDto userRegister(@RequestBody Object user);

    @RequestMapping(value = "/getuserinfo", method = RequestMethod.POST)
    ResultDto getUserInfo(@RequestBody String user_email);

    @RequestMapping(value = "/updateuser")
    ResultDto updateUser(@RequestBody Object user);

    @RequestMapping(value = "/deleteuser")
    ResultDto deleteUser(@RequestBody String user_email);
}
