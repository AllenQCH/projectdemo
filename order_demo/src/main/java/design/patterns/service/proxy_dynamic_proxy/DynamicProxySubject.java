package design.patterns.service.proxy_dynamic_proxy;

import org.springframework.cglib.proxy.InvocationHandler;

import java.lang.reflect.Method;

public class DynamicProxySubject implements InvocationHandler {
    private Object realSubject;

    public DynamicProxySubject(Object realSubject) {
        this.realSubject = realSubject;
    }
    //当我们通过代理类的对象，调用方法request时，就会自动的调用如下的方法: invoke()
    //将被代理类要执行的方法的功能就言明在invoke()中
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //method: 即为代理类对象调用的方法，此方法也就作为了被代理类对象要调用的方法
        //realSubject: 被代理类的对象
        System.out.println("DynamicProxySubject:before " + method.getName() + "()");
        Object result = method.invoke(realSubject, args);
        System.out.println("DynamicProxySubject:after " + method.getName() + "()");
        //上述方法的返回值就作为当前类中的invoke()的返回值。
        return result;
    }
}