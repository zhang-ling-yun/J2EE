package cn.edu.scut.spring.service.impl;

import cn.edu.scut.spring.entity.Product;
import cn.edu.scut.spring.service.ProductService;


/**
 * @author: rain
 * @date: 2019-4-7 16:58
 * @description: 商品业务逻辑实现类
 */
public class ProductServiceImpl implements ProductService {

    @Override
    public int addProduct(Product product) {
        System.out.println("增加了一件商品：" + product);
        return 0;
    }

    @Override
    public int deleteProduct(Integer id) {
        System.out.println("删除了一件商品：" + id);
        return 0;
    }
}
