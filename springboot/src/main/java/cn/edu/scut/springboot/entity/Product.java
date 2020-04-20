package cn.edu.scut.springboot.entity;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author: rain
 * @date: 2019-4-22 10:02
 * @description: springboot
 */
@Data
public class Product {
    private Integer id;

    private Category category;

    private String name;

    private BigDecimal price;

    private Date createTime;
}
