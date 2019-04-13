package cn.edu.scut.spring.entity;

import cn.edu.scut.spring.proxy.ObjectInterceptor;
import cn.edu.scut.spring.proxy.ProductMethodInterceptor;
import cn.edu.scut.spring.proxy.ProxyProduct;
import cn.edu.scut.spring.service.ProductService;
import cn.edu.scut.spring.service.impl.ProductServiceImpl;
import cn.edu.scut.spring.transaction.LogTransaction;
import org.junit.Test;
import org.springframework.cglib.core.DebuggingClassWriter;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.lang.reflect.Proxy;
import java.math.BigDecimal;
import java.util.Date;

import static org.junit.Assert.*;

/**
 * @author: rain
 * @date: 2019-4-7 14:30
 * @description:
 */
public class ProductTest {

    @Test
    public void testProduct() {
        Product product = new Product();
        product.setId(1);
        product.setName("Java编程思想");
        // 对于BigDecimal的使用可以看一下：https://www.cnblogs.com/javahr/p/8321683.html
        product.setPrice(new BigDecimal("12.35"));
        product.setCreateTime(new Date());
        System.out.println(product);
    }

    @Test
    public void testCreateOne() {
        //1、启动 spring 容器
        ApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");
        Product product = (Product) context.getBean("product");
        System.out.println(product);

        Product product1 = (Product) context.getBean("product");
        System.out.println(product1);
        System.out.println("product == product1： " + (product == product1));
    }

    @Test
    public void testCreateTwo() {
        //1、启动 spring 容器
        ApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");
        Product product = (Product) context.getBean("product2");
        System.out.println(product);
        Product product1 = (Product) context.getBean("product2");
        System.out.println(product1);
        System.out.println("product == product1： " + (product == product1));
    }

    @Test
    public void testCreateAnnotation() {
        //1、启动 spring 容器
        ApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");
        Category category = (Category) context.getBean("category");
        System.out.println(category);
    }

    @Test
    public void testSpringLifeCycle(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        SpringLifeCycle hello = (SpringLifeCycle) context.getBean("springLifeCycle");

        hello.sayHello();

        //销毁spring容器
        ClassPathXmlApplicationContext classContext = (ClassPathXmlApplicationContext) context;
        classContext.close();
    }

    @Test
    public void testStaticProxy() {
        LogTransaction logTransaction = new LogTransaction();
        ProductService productService = new ProductServiceImpl();
        //产生静态代理对象
        ProxyProduct proxyProduct = new ProxyProduct(productService,logTransaction);
        proxyProduct.addProduct(null);
        productService.deleteProduct(0);
    }

    @Test
    public void testDynamicProxy() {
        Object target = new ProductServiceImpl();
        LogTransaction logTransaction = new LogTransaction();
        ObjectInterceptor proxyObject = new ObjectInterceptor(target,logTransaction);
        /**
         * 三个参数的含义：
         * 1、目标类的类加载器
         * 2、目标类所有实现的接口
         * 3、拦截器
         */
        ProductService productService = (ProductService) Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),proxyObject);
        productService.addProduct(new Product());
    }

    @Test
    public void testCglib() {
        // 代理类class文件存入本地磁盘方便我们反编译查看源码
        // System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "D:\\code");
        // 通过CGLIB动态代理获取代理对象的过程
        Enhancer enhancer = new Enhancer();
        // 设置enhancer对象的父类
        enhancer.setSuperclass(ProductServiceImpl.class);
        LogTransaction logTransaction = new LogTransaction();
        // 设置enhancer的回调对象
        enhancer.setCallback(new ProductMethodInterceptor(logTransaction));
        // 创建代理对象
        ProductServiceImpl proxy= (ProductServiceImpl)enhancer.create();
        // 通过代理对象调用目标方法
        proxy.addProduct(new Product());
    }

    @Test
    public void testAop() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        ProductService productService = (ProductService) context.getBean("productService");
        productService.addProduct(new Product());
    }
}