package com.threadpool.demo.config;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Method;

/**
 * 创建一个通过反射执行方法的工具类ReflectionUtil
 */
public class ReflectionUtil {

    private static Logger logger = LoggerFactory.getLogger(ReflectionUtil.class);

    /**
     * *通过反射的方式调用对象方法
     *
     * @param object 服务对象
     * @param methodName 调用方法
     * @param args 方法参数(具有顺序性)
     */
    public static void invokeMethod(Object object, String methodName, Object[] args)
            throws Exception {
        logger.debug(" invokeMethod start : 服务对象={},调用方法={} ", new Object[] {object, methodName});
        Class<?>[] paramClasses = null;
        if (args.length > 0) {
            paramClasses = new Class<?>[args.length];
            for (int i = 0; i < args.length; i++) {
                paramClasses[i] = args[i].getClass();
            }
        }
        Method method = object.getClass().getMethod(methodName, paramClasses);
        method.setAccessible(true);
        method.invoke(object, args);
        logger.debug(" invokeMethod end ");
    }
}
