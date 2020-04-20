package cn.edu.scut.mybatis.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author: rain
 * @date: 2019-3-31 00:27
 * @description:
 */
public class SessionFactoryUtil {
    /**
     * 单例模式创建实体
     */
    private static SqlSessionFactory sessionFactory;

    /**
     * 私有化构造方法
     */
    private SessionFactoryUtil(){}

    /**
     * 对外提供session获取接口
     * @return
     */
    public static synchronized SqlSession getSession(){
        try {
            InputStream stream = Resources.getResourceAsStream("mybatis-config.xml");
            // 判断SqlSessionFactory是否为空，如果为空则创建
            if(sessionFactory == null){
                sessionFactory = new SqlSessionFactoryBuilder().build(stream);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 还有一种方式就是在获取session的同时设置自动提交sessionFactory.openSession(true)
        return sessionFactory.openSession();
    }
}
