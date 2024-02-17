package design.patterns.service.singtone;


public class LazySingleton2 {
    // 被volatile修饰的变量可以确保多个线程能正常处理
    private volatile static LazySingleton2 instance = null;

    private LazySingleton2() {
    }

    public static LazySingleton2 getInstance() {
        // 第一层判断，如果实例已经创建，跳过
        if (instance == null) {
            synchronized (LazySingleton2.class) {
                // 第二层判断，如果实例创建，跳过
                if (instance == null) {
                    instance = new LazySingleton2();
                }
            }
        }
        return instance;
    }
}