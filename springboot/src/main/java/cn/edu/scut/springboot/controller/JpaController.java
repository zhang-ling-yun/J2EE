package cn.edu.scut.springboot.controller;

import cn.edu.scut.springboot.dao.CategoryDao;
import cn.edu.scut.springboot.entity.Category;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author: rain
 * @date: 2019-4-22 15:22
 * @description: springboot
 */
@Api(tags = "JpaController")
@RestController
public class JpaController {

    @Autowired
    private CategoryDao categoryDao;

    @ApiOperation(value="获取商品类别列表", notes="获取商品类别列表")
    @RequestMapping(value = "/category/list", method = RequestMethod.GET)
    public List<Category> getCategoryList() {
        return categoryDao.findAll();
    }
}
