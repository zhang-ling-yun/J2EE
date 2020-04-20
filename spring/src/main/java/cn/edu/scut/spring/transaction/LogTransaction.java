package cn.edu.scut.spring.transaction;

/**
 * @author: rain
 * @date: 2019-4-7 17:00
 * @description: 事务切面类
 */
public class LogTransaction {
    public void before(){
        System.out.println("======插入前置通知======");
    }

    public void after(){
        System.out.println("======插入后者通知======");
    }
}
