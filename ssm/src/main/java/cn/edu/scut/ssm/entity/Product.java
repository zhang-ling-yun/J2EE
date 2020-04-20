package cn.edu.scut.ssm.entity;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author: rain
 * @date: 2019-4-19 09:55
 * @description: ssm
 */
@Data
public class Product {
    private Integer id;

    private Category category;

    private String name;

    private BigDecimal price;

    private Date createTime;
}
