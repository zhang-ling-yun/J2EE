package cn.edu.scut.springboot.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

/**
 * @author: rain
 * @date: 2019-4-22 23:18
 * @description: springboot
 */
@JsonIgnoreProperties(ignoreUnknown=true)
@Data
public class User {

    private String name;
    private String blog;

}
