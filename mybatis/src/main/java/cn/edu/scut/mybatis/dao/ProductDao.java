package cn.edu.scut.mybatis.dao;

import cn.edu.scut.mybatis.entity.Product;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author: rain
 * @date: 2019-4-1 09:07
 * @description:
 */
public interface ProductDao {
    /**
     * 获取商品列表
     * @return
     */
    List<Product> listProduct();

    /**
     * 添加商品
     * @param product
     * @return
     */
    int addProduct(Product product);

    /**
     * 更新商品
     * @param product
     * @return
     */
    int updateProduct(Product product);

    /**
     * 根据id查询单条商品
     * @param id
     * @return
     */
    Product getProduct(Integer id);

    /**
     * 根据id删除单条商品
     * @param id
     * @return
     */
    int deleteProduct(Integer id);

    /**
     * 根据名称模糊查询商品列表,这边不加上@Param("name")可能会报错
     * @param name
     * @return
     */
    List<Product> listProductByName(String name);

    /**
     * 根据名称和价格模糊查询商品列表
     * @param name
     * @param price
     * @return
     */
    List<Product> listProductByNameAndPrice(@Param("name") String name, @Param("price") Double price);

    /**
     * 使用choose标签查询商品列表
     * @param name
     * @param price
     * @return
     */
    List<Product> testChoose(@Param("name") String name,@Param("price") Double price);

    /**
     * 使用foreach标签查询商品列表
     * @param ids
     * @return
     */
    List<Product> testForeach(List<Integer> ids);

    /**
     * 使用bind标签查询商品列表
     * @param name
     * @return
     */
    List<Product> testBind(@Param("name") String name);
}
