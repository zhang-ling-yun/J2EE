package cn.edu.scut.springboot.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author: Administrator
 * @Date: 2019-3-12 23:29
 * @Description:
 */
@Configuration
public class WebConfigurer implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/tybx/**").addResourceLocations("file:D:/tybx/wechat/files/");
    }
}
