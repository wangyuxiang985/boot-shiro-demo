package com.wyx.shiro.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName TestController
 * @Description 验证服务联通性
 * @Author yuxiang
 * @Date 2020/1/13
 * @Version 1.0
 **/
@RestController
@CrossOrigin(origins = "*",allowCredentials = "true")
@RequestMapping("/test")
@Api(value = "TestController",tags = {"验证服务联通性"})
public class TestController {

    @GetMapping(value = "/hello")
    @ApiOperation("验证服务是否正常")
    public String helloSpringBoot() {
        return "SUCCESS";
    }
}
