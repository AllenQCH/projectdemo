package design.patterns.service.singtone;


public class HungryDemo {
    // 类加载，初始化
    private  static  final  HungryDemo instance = new HungryDemo();

    private HungryDemo(){}
    public static HungryDemo getInstance(){
        return instance;
    }
}
