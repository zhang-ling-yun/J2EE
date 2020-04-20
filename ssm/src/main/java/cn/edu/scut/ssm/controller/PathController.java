package cn.edu.scut.ssm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author: rain
 * @date: 2019-4-19 14:27
 * @description: ssm
 */
@Controller
public class PathController {

    @GetMapping("/home")
    public String home() {
        return "home";
    }

}
