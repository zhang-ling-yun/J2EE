package cn.edu.scut.springboot.dao.impl;

import cn.edu.scut.springboot.dao.ProductDao;
import cn.edu.scut.springboot.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author: rain
 * @date: 2019-4-22 10:08
 * @description: springboot
 */
@Repository
public class ProductDaoImpl implements ProductDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Product> selectProductList() {
        List<Product> list = jdbcTemplate.query("select * from product", new Object[]{}, new BeanPropertyRowMapper(Product.class));
        if (list != null && list.size() > 0) {
            return list;
        } else {
            return null;
        }
    }
}
