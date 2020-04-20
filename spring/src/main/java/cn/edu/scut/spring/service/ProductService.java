package cn.edu.scut.spring.service;

import cn.edu.scut.spring.entity.Product;

/**
 * @author: rain
 * @date: 2019-4-7 16:57
 * @description: 商品业务逻辑接口
 */
public interface ProductService {
    /**
     * 添加商品
     * @param product
     * @return
     */
    int addProduct(Product product);

    /**
     * 删除商品
     * @param id
     * @return
     */
    int deleteProduct(Integer id);
}
