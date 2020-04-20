package cn.edu.scut.springboot.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * @author: rain
 * @date: 2019-4-22 10:03
 * @description: springboot
 */
@Data
@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Integer id;

    private String name;
}
