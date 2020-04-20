package cn.edu.scut.springmvc.controller;

import cn.edu.scut.springmvc.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;

/**
 * @author: rain
 * @date: 2019-4-15 09:24
 * @description: springmvc
 */
@Controller
public class FormController {

    @RequestMapping("/redirect")
    public String redirect() {
        return "redirect:hello";
    }

    @RequestMapping("/form")
    public String add(ModelMap map) {
        User user = new User();
        user.setPassword("123456");
        user.setUserName("rain");

        map.put("userInfo", user);
        return "form/add";
    }

    @RequestMapping("/form/index")
    public String index(ModelMap map) {
        map.put("username", "入门案例");

        User user = new User();
        user.setPassword("123456");
        user.setUserName("rain");

        map.put("userInfo", user);
        return "form/index";
    }

    @ResponseBody
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(@ModelAttribute User user) {
        String username = user.getUserName();
        String password = user.getPassword();
        return username + "__" + password;
    }

    @ResponseBody
    @RequestMapping(value = "/jsonTest", method = RequestMethod.GET)
    public HashMap<String, Object> jsonTest() {
        HashMap<String, Object> resultMap = new HashMap<>();
        User user = new User();
        user.setPassword("123456");
        user.setUserName("rain");
        resultMap.put("user", user);
        resultMap.put("success", true);
        return resultMap;
    }
}
