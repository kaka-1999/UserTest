package cookieMethod;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@Api(value = "/", description = "post方法")
@RequestMapping("/post")
public class MyPostMethod {
    Cookie cookie;

    /**
     * post请求
     * 账号验证并返回cookie
     * @param response
     * @param name
     * @param pass
     * @return
     */
    @RequestMapping(value = "/method1", method = RequestMethod.POST)
    @ApiOperation(value = "/", httpMethod = "POST")
    public String PostMethod(HttpServletResponse response,
                             @RequestParam(value = "username", required = true) String name,
                             @RequestParam(value = "password", required = false) String pass) {
        cookie = new Cookie("login", "8888");
        response.addCookie(cookie);
        if (name.equals("xiaotaoqi") && pass.equals("888888")) {
            return "login success";
        }
        return "login fail";
    }

    /**
     * post请求
     * 验证cookie并返回user
     * @param request
     * @param user
     * @return
     */
    @RequestMapping(value = "/getUserList", method = RequestMethod.POST)
    @ApiOperation(value = "返回列表", httpMethod = "POST")
    public String getUserList(HttpServletRequest request, @RequestBody User user) {
        Cookie[] cookie1 = request.getCookies();
        for (Cookie c : cookie1) {
            if (c.getName().equals("cookiename") && c.getValue().equals("good")) {
                if (user.getUsername().equals("kaka") && user.getPassword().equals("888")) {
                    User user1 = new User();
                    user1.setUser("lisi");
                    user1.setAge("18");
                    user1.setSex("man");
                    return user1.toString();
                }
            }
        }
        return "参数不合法";
    }
}
