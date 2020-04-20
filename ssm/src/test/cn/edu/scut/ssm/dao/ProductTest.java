package cn.edu.scut.ssm.dao;

import cn.edu.scut.ssm.BaseTest;
import cn.edu.scut.ssm.entity.Product;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author: rain
 * @date: 2019-4-19 10:42
 * @description: ssm
 */
public class ProductTest extends BaseTest {
    @Autowired
    private ProductDao productDao;

    @Test
    public void testQueryArea() {
        List<Product> productList = productDao.selectProductList(null);
        System.out.println(productList.get(0));
    }
}
