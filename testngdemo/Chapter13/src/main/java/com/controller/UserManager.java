package com.controller;

import com.model.Admin_User;
import com.model.LoginUser;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j2;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;


@RestController
@Api(value = "/v1", description = "用户管理")
@RequestMapping("vl")
@Log4j2
public class UserManager {
    @Autowired
    private SqlSessionTemplate template;

    /**
     * 登录用户接口实现
     *
     * @param response
     * @param user
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ApiOperation(value = "登录", httpMethod = "POST")
    public boolean login(HttpServletResponse response, @RequestBody LoginUser user) {
        int result = template.selectOne("login", user);
        log.info("登录user:"+user);
        if (result > 0) {
            response.addCookie(new Cookie("login", "88888"));
            return true;
        }
        return false;
    }

    /**
     * 添加用户接口实现
     *
     * @param request
     * @param user
     * @return
     */
    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    @ApiOperation(value = "新增", httpMethod = "POST")
    public boolean addUser(HttpServletRequest request, @RequestBody Admin_User user) {
        log.info("新增用户："+user);
        if (verifyCookies(request)) {
            System.out.println("cookies验证通过");
            int result = template.insert("addUser", user);
            if (result == 1) {
                return true;
            }
        }
        return false;
    }

    /**
     * 获取用户列表接口实现
     *
     * @param request
     * @param userList
     * @return
     */
    @RequestMapping(value = "/UserList", method = RequestMethod.POST)
    @ApiOperation(value = "用户列表", httpMethod = "POST")
    public List<Admin_User> getUserList(HttpServletRequest request, @RequestBody Admin_User userList) {
        log.info("用户列表："+userList);
        List<Admin_User> users;
        if (verifyCookies(request)) {
            users = template.selectList("UserList", userList);
            return users;
        } else {
            System.out.println("cookie验证失败");
            return null;
        }
    }

    /**
     * 更新/删除用户接口实现
     *
     * @param request
     * @param user
     * @return
     */
    @RequestMapping(value = "/UpdateUser", method = RequestMethod.POST)
    @ApiOperation(value = "更新/删除接口", httpMethod = "POST")
    public int UpdateUser(HttpServletRequest request, @RequestBody Admin_User user) {
        log.info("更新用户："+user);
        if (verifyCookies(request)) {
            return template.update("UpdateUser", user);
        } else {
            return -1;
        }
    }


    /**
     * 验证cookies
     *
     * @param request
     * @return
     */
    public boolean verifyCookies(HttpServletRequest request) {
        Cookie[] cookie = request.getCookies();
        for (Cookie c : cookie) {
            System.out.println(cookie);
            if (c.getName().equals("login") && c.getValue().equals("88888")) {
                return true;
            }
        }
        return false;
    }
}
