package design.patterns.service.proxy_static;


public class RealSubject implements Subject {
    @Override
    public void request() {
        System.out.println("RealSubject:request()");
    }
}

