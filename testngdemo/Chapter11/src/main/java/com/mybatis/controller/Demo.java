package com.mybatis.controller;

import com.mybatis.model.UpdateLog;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Api(value = "/mybatis", description = "第一个mybatis")
@RequestMapping("/mybatis")

public class Demo {
    //@Autowired 注释，它可以对类成员变量、方法及构造函数进行标注，完成自动装配的工作
    //启动机加载
    @Autowired
    private SqlSessionTemplate template;

    //查询数据库
    @RequestMapping(value = "/UpdateLogCount", method = RequestMethod.GET)
    @ApiOperation(value = "日志总数", httpMethod = "GET")
    public int getUpdateLog() {
        return template.selectOne("GetLogCount");
    }

    //新增数据
    @RequestMapping(value = "/AddUpdateLog", method = RequestMethod.POST)
    @ApiOperation(value = "新增日志", httpMethod = "Post")
    public int addUpdateLog(@RequestBody UpdateLog log) {
        int result = template.insert("AddLog", log);
        return result;
    }

    //更新数据
    @RequestMapping(value = "/UpdateLog", method = RequestMethod.POST)
    @ApiOperation(value = "更新日志", httpMethod = "POST")
    public int UpdateLog(@RequestBody UpdateLog log) {
        return template.update("UpdateLog", log);
    }

    //删除数据
    @RequestMapping(value = "/DeleteLog", method = RequestMethod.POST)
    @ApiOperation(value = "删除日志", httpMethod = "POST")
    public int DeleteLog(@RequestParam int id) {
        return template.delete("DeleteLog", id);
    }

}
