package cn.edu.scut.spring.entity;

/**
 * @author: rain
 * @date: 2019-4-7 16:20
 * @description:
 */
public class SpringLifeCycle {
    public SpringLifeCycle(){
        System.out.println("SpringLifeCycle");
    }
    /**
     * 定义初始化方法
     */
    public void init(){
        System.out.println("init...");
    }
    /**
     * 定义销毁方法
     */
    public void destroy(){
        System.out.println("destroy...");
    }

    public void sayHello(){
        System.out.println("say Hello...");
    }
}
