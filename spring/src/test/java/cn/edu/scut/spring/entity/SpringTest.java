package cn.edu.scut.spring.entity;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author: rain
 * @date: 2019-4-7 19:07
 * @description:
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath*:applicationContext.xml"})
public class SpringTest {

    @Test
    public void testProduct() {
        Product product = new Product();
        product.setId(1);
        product.setName("Java核心技术卷I");
        product.setPrice(new BigDecimal("95.963"));
        product.setCreateTime(new Date());
        System.out.println(product);
    }
}
