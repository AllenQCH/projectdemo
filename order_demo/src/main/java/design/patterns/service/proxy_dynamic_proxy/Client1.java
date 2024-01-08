package design.patterns.service.proxy_dynamic_proxy;

import org.springframework.cglib.proxy.Proxy;

public class Client1 {
    public static void main(String[] args) {
        RealSubject realSubject = new RealSubject();
        DynamicProxySubject dynamicProxySubject = new DynamicProxySubject(realSubject);
        //调用此方法，返回一个代理类的对象。解决问题一
        Subject proxySubject = (Subject) Proxy.newProxyInstance(realSubject.getClass().getClassLoader(),
                realSubject.getClass().getInterfaces(), dynamicProxySubject);
        proxySubject.request();
    }
}