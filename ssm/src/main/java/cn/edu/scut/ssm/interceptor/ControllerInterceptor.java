package cn.edu.scut.ssm.interceptor;

import org.aspectj.lang.ProceedingJoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author: rain
 * @date: 2019-4-20 17:25
 * @description: ssm
 */
public class ControllerInterceptor {

    private static final Logger log = LoggerFactory.getLogger(ControllerInterceptor.class);

    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        Object object = joinPoint.proceed();
        long end = System.currentTimeMillis();
        long takeTime = end - start;
        String className = joinPoint.getSignature().toString();
        log.info("运行类：className={}`接口耗时takeTime={}ms",className,takeTime);
        return object;
    }
}
