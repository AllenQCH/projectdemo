package design.patterns.service.proxy_dynamic_cglib;

public class RealSubject implements Subject {
    @Override
    public void request() {
        System.out.println("RealSubject:request()");
    }
}

