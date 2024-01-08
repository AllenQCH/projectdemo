package design.patterns.service.proxy_dynamic_cglib;

import org.springframework.cglib.proxy.Enhancer;

public class Client2 {
    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(RealSubject.class);
        enhancer.setCallback(new DynamicProxySubject2(new RealSubject()));
        RealSubject proxySubject = (RealSubject) enhancer.create();
        proxySubject.request();
    }
}