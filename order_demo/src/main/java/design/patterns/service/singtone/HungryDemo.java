package design.patterns.service.singtone;


public class HungryDemo {
    private  static  final  HungryDemo instance = new HungryDemo();

    private HungryDemo(){}
    public static HungryDemo getInstance(){
        return instance;
    }
}
