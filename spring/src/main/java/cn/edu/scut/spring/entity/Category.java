package cn.edu.scut.spring.entity;

import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * @author: rain
 * @date: 2019-4-7 16:08
 * @description: 商品类别表
 */
@Data
@Component("category")
public class Category {
    private Integer id;
    /**
     * 类别名称
     */
    private String name = "Java系列";
}
