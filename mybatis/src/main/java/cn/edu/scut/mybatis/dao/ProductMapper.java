package cn.edu.scut.mybatis.dao;

import cn.edu.scut.mybatis.entity.Product;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * @author: rain
 * @date: 2019-4-1 22:47
 * @description:
 */
public interface ProductMapper {
    @Insert(" insert into product (name,price) values (#{name},#{price}) ")
    int add(Product product);

    @Delete("delete from product where id= #{id} ")
    int delete(int id);

    @Update("update product set name=#{name} where id=#{id} ")
    int update(Product product);

    @Select(" select * from product ")
    List<Product> list();
}
