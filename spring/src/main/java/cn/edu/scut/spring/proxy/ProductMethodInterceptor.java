package cn.edu.scut.spring.proxy;

import cn.edu.scut.spring.transaction.LogTransaction;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author: rain
 * @date: 2019-4-7 18:49
 * @description:
 */
public class ProductMethodInterceptor implements MethodInterceptor {
    private LogTransaction logTransaction;

    public ProductMethodInterceptor(LogTransaction logTransaction) {
        this.logTransaction = logTransaction;
    }

    @Override
    public Object intercept(Object sub, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        this.logTransaction.before();
        Object object = methodProxy.invokeSuper(sub, objects);
        this.logTransaction.after();
        return object;
    }
}
