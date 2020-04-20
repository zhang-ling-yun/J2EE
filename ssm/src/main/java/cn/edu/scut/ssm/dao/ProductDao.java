package cn.edu.scut.ssm.dao;

import cn.edu.scut.ssm.entity.Product;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * @author: rain
 * @date: 2019-4-19 10:05
 * @description: ssm
 */
public interface ProductDao {
    /**
     * 查询商品列表
     * @param params 前端传递的参数
     * @return
     */
    List<Product> selectProductList(Map<String,Object> params);

    /**
     * 添加一个商品
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
     * 删除一个商品
     * @param id
     * @return
     */
    int deleteProduct(Integer id);
}
