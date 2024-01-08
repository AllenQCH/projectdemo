package design.patterns.service.proxy_dynamic_cglib;

import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class DynamicProxySubject2 implements MethodInterceptor {
    private Object realSubject;

    public DynamicProxySubject2(Object realSubject) {
        this.realSubject = realSubject;
    }

    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        System.out.println("DynamicProxySubject:before " + method.getName() + "()");
        Object result = proxy.invoke(realSubject, args);
        System.out.println("DynamicProxySubject:after " + method.getName() + "()");
        return result;
    }
}