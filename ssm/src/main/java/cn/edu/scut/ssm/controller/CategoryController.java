package cn.edu.scut.ssm.controller;

import cn.edu.scut.ssm.entity.Category;
import cn.edu.scut.ssm.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: rain
 * @date: 2019-4-20 00:06
 * @description: ssm
 */
@Controller
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @ResponseBody
    @RequestMapping("/category/all")
    public HashMap<String,Object> all() {
        HashMap<String,Object> resultMap = new HashMap<>();
        List<Category> categoryList = categoryService.selectCategoryList();
        List<HashMap<String, Object>> rows = new ArrayList<HashMap<String, Object>>();
        for (int i = 0; i < categoryList.size(); i++) {
            Map<String, Object> result = new HashMap<String, Object>();
            Category category = categoryList.get(i);
            result.put("id", category.getId());
            result.put("text", category.getName());
            rows.add((HashMap<String, Object>) result);
        }
        resultMap.put("data",rows);
        return resultMap;
    }
}
