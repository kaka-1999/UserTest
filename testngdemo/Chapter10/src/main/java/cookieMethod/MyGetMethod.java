package cookieMethod;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@RestController
@Api(value = "/",description = "get接口")
public class MyGetMethod {
    /**
     * 无参数的get请求
     *
     * @param response
     * @return
     */
    @RequestMapping(value = "/springboot/get", method = RequestMethod.GET)
    @ApiOperation(value = "无参数的get请求",httpMethod = "GET")
    public String getCoolies(HttpServletResponse response) {
        Cookie cookie = new Cookie("login", "kaka");
        response.addCookie(cookie);
        return "恭喜你获得cookies";
    }

    /**
     * 带参数的get请求
     * 第一种方式：url地址中key=value的方式传递参数
     *
     * @param page
     * @param size
     * @return
     */
    @RequestMapping(value = "springboot/param", method = RequestMethod.GET)
    @ApiOperation(value = "带参数的get请求,第一种方式",httpMethod = "GET")
    public Map<String, Integer> getKeyList(@RequestParam Integer page, @RequestParam Integer size) {
        Map<String, Integer> myList = new HashMap<>();
        myList.put("name", 1);
        myList.put("age", 2);
        myList.put("sex", 3);

        return myList;
    }

    /**
     * 带参数的get请求
     * 第二种方式：url地址中path带参数的方式传递
     * 譬如：http://localhost:8888/springboot/path/{page}/{size}
     * @param page
     * @param size
     * @return
     */
    @RequestMapping(value = "/springboot/path/{page}/{size}",method = RequestMethod.GET)
    @ApiOperation(value = "带参数的get请求,第2种方式",httpMethod = "GET")
    public Map<String ,Integer> getPathList(@PathVariable Integer page,@PathVariable Integer size){
        Map<String, Integer> myList = new HashMap<>();
        myList.put("name", 1);
        myList.put("age", 2);
        myList.put("sex", 3);

        return myList;
    }
}
