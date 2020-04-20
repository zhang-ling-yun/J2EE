package cn.edu.scut.springboot.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.DateFormat;
import java.util.Date;

/**
 * @author: rain
 * @date: 2019-4-22 19:01
 * @description: springboot
 */
@Controller
public class HelloController {

    @RequestMapping("/hello")
    public String hello(Model m) throws Exception {
        m.addAttribute("now", DateFormat.getDateTimeInstance().format(new Date()));
        if(true){
            throw new Exception("some exception");
        }
        return "hello";
    }

}
