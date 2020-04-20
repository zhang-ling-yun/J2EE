package cn.edu.scut.springboot.dao;

import cn.edu.scut.springboot.entity.Product;

import java.util.List;

/**
 * @author: rain
 * @date: 2019-4-22 10:07
 * @description: springboot
 */
public interface ProductDao {
    /**
     * 获取所有商品
     * @return
     */
    List<Product> selectProductList();
}
