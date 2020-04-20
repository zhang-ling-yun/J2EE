package cn.edu.scut.ssm.controller;

import cn.edu.scut.ssm.entity.Product;
import cn.edu.scut.ssm.service.ProductService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: rain
 * @date: 2019-4-19 11:23
 * @description: ssm
 */
@Controller
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping("/product/page")
    public String page() {
        return "product/page";
    }

    @ResponseBody
    @RequestMapping("/product/list")
    public HashMap<String, Object> selectProductList(HttpServletRequest request) {
        HashMap<String, Object> resultMap = new HashMap<>();
        Map<String, Object> params = new HashMap<>();
        String name = request.getParameter("name");
        int pageNo = Integer.parseInt(request.getParameter("page"));
        int pageSize = Integer.parseInt(request.getParameter("rows"));
        params.put("name", name);
        PageInfo<Product> page = productService.selectProductList(params, pageNo, pageSize);
        List<HashMap<String, Object>> rows = new ArrayList<HashMap<String, Object>>();
        List<Product> productList = page.getList();
        for (int i = 0; i < productList.size(); i++) {
            Map<String, Object> result = new HashMap<String, Object>();
            Product product = productList.get(i);
            result.put("id", product.getId());
            result.put("name", product.getName());
            result.put("price", product.getPrice());
            result.put("categoryName", product.getCategory().getName());
            result.put("createTime", product.getCreateTime());
            rows.add((HashMap<String, Object>) result);
        }
        resultMap.put("rows", rows);
        resultMap.put("total", page.getTotal());
        return resultMap;
    }

    @ResponseBody
    @RequestMapping("/product/save")
    public HashMap<String, Object> addProduct(@RequestBody Product product) {
        HashMap<String, Object> resultMap = new HashMap<>();
        try {
            int result = productService.addProduct(product);
            if (result == 1) {
                resultMap.put("success",true);
                resultMap.put("msg","商品添加成功");
            } else {
                resultMap.put("success",false);
                resultMap.put("msg","商品添加失败,请重试!");
            }
        } catch (Exception e) {
            resultMap.put("success",false);
            resultMap.put("msg","商品添加失败,请重试!");
        }
        return resultMap;
    }

    @ResponseBody
    @RequestMapping("/product/update")
    public HashMap<String, Object> updateProduct(@RequestBody Product product) {
        HashMap<String, Object> resultMap = new HashMap<>();
        try {
            int result = productService.updateProduct(product);
            if (result == 1) {
                resultMap.put("success",true);
                resultMap.put("msg","商品详情更新成功");
            } else {
                resultMap.put("success",false);
                resultMap.put("msg","商品详情更新失败,请重试!");
            }
        } catch (Exception e) {
            resultMap.put("success",false);
            resultMap.put("msg","商品详情更新失败,请重试!");
        }
        return resultMap;
    }

    @ResponseBody
    @RequestMapping("/product/delete")
    public HashMap<String, Object> deleteProduct(Integer id) {
        HashMap<String, Object> resultMap = new HashMap<>();
        try {
            int result = productService.deleteProduct(id);
            if (result == 1) {
                resultMap.put("success",true);
                resultMap.put("msg","商品删除成功");
            } else {
                resultMap.put("success",false);
                resultMap.put("msg","商品删除失败,请重试!");
            }
        } catch (Exception e) {
            resultMap.put("success",false);
            resultMap.put("msg","商品删除失败,请重试!");
        }
        return resultMap;
    }
}
