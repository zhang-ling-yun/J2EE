package cn.edu.scut.spring.entity;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author: rain
 * @date: 2019-4-7 14:10
 * @description: 商品实体类
 */
@Data
public class Product {
    private Integer id;
    /**
     * 商品名称
     */
    private String name;
    /**
     * 价格
     */
    private BigDecimal price;
    /**
     * 创建时间
     */
    private Date createTime;

    public Product() {
    }

    public Product(Integer id, String name, BigDecimal price, Date createTime) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.createTime = createTime;
    }
}
