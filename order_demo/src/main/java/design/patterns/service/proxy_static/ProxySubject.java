package design.patterns.service.proxy_static;


public class ProxySubject implements Subject {
    private RealSubject realSubject;

    public ProxySubject(RealSubject realSubject) {
        this.realSubject = realSubject;
    }

    @Override
    public void request() {
        System.out.println("ProxySubject:before request()");
        realSubject.request();
        System.out.println("ProxySubject:after request()");
    }
}
