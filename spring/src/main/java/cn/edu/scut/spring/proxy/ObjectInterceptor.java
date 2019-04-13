package cn.edu.scut.spring.proxy;

import cn.edu.scut.spring.transaction.LogTransaction;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author: rain
 * @date: 2019-4-7 17:13
 * @description: 动态代理类
 */
public class ObjectInterceptor implements InvocationHandler {
    /**
     * 目标类
     */
    private Object target;
    /**
     * 切面类
     */
    private LogTransaction logTransaction;

    /**
     * 通过构造器赋值
     */
    public ObjectInterceptor(Object target,LogTransaction transaction){
        this.target = target;
        this.logTransaction = transaction;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //开启事务
        this.logTransaction.before();
        //调用目标类方法
        Object result = method.invoke(this.target, args);
        //提交事务
        this.logTransaction.after();
        System.out.println(result);
        return result;
    }
}
