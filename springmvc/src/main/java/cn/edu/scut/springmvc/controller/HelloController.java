package cn.edu.scut.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author: rain
 * @date: 2019-4-14 22:55
 * @description: springmvc
 */
@Controller
@RequestMapping("/")
public class HelloController {
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String submit(ModelMap model) {
        model.addAttribute("name", "rain");
        model.addAttribute("phone", "13265910904");
        model.addAttribute("email", "1316095861@qq.com");
        return "hello";
    }
}