package cn.edu.scut.springboot.service;

import cn.edu.scut.springboot.entity.Product;

import java.util.List;

/**
 * @author: rain
 * @date: 2019-4-22 10:19
 * @description: springboot
 */
public interface ProductService {

    List<Product> selectList();
}
