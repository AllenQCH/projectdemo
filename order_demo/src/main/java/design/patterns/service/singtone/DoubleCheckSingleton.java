package design.patterns.service.singtone;

/**
 * 单例模式-双重校验模式
 */
public class DoubleCheckSingleton {
    // 被volatile修饰的变量可以确保多个线程能正常处理
    private volatile static DoubleCheckSingleton instance = null;

    private DoubleCheckSingleton() {
    }

    public static DoubleCheckSingleton getInstance() {
        // 第一层判断，如果实例已经创建，跳过
        if (instance == null) {
            synchronized (DoubleCheckSingleton.class) {
                // 第二层判断，如果实例创建，跳过
                if (instance == null) {
                    instance = new DoubleCheckSingleton();
                }
            }
        }
        return instance;
    }

}