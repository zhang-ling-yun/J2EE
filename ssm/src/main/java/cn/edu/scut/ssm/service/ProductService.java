package cn.edu.scut.ssm.service;

import cn.edu.scut.ssm.entity.Product;
import com.github.pagehelper.PageInfo;

import java.util.Map;

/**
 * @author: rain
 * @date: 2019-4-19 10:50
 * @description: ssm
 */
public interface ProductService {
    /**
     * 根据参数分页查询商品
     * @param params
     * @param pageNo
     * @param pageSize
     * @return
     */
    PageInfo<Product> selectProductList(Map<String,Object> params,int pageNo,int pageSize);

    /**
     * 添加商品
     * @param product
     * @return
     */
    int addProduct(Product product);

    /**
     * 更新商品详情
     * @param product
     * @return
     */
    int updateProduct(Product product);

    /**
     * 删除商品
     * @param id
     * @return
     */
    int deleteProduct(Integer id);
}
