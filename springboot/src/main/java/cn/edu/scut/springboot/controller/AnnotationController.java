package cn.edu.scut.springboot.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: rain
 * @date: 2019-4-22 09:26
 * @description: springboot
 */
@Api(tags = "AnnotationController")
@RestController
public class AnnotationController {

    @Value("${my.name}")
    private String name;
    @Value("${my.age}")
    private int age;

    @ApiOperation(value="演示使用@Value的方式注入配置属性", notes="演示使用@Value的方式注入配置属性")
    @RequestMapping(value = "/my")
    public String my() {
        return name + ":" + age;
    }

}
