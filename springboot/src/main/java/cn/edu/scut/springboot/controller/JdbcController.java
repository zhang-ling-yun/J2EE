package cn.edu.scut.springboot.controller;

import cn.edu.scut.springboot.entity.Product;
import cn.edu.scut.springboot.service.ProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author: rain
 * @date: 2019-4-22 10:10
 * @description: springboot
 */
@Api(tags = "JdbcController")
@RestController
public class JdbcController {

    @Autowired
    private ProductService productService;

    @ApiOperation(value="获取商品列表", notes="获取商品列表")
    @RequestMapping(value = "/product/list",method = RequestMethod.GET)
    public List<Product> getProducts(){
        return productService.selectList();
    }
}
