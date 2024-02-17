package design.patterns.service.singtone;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class HungryDemo {
    // 类加载，初始化
    private  static  final  HungryDemo instance = new HungryDemo();

    private HungryDemo(){}
    public static HungryDemo getInstance(){
        return instance;
    }

    public static void main(String[] args) {
        ConcurrentHashMap<String,String> concurrentHashMap = new ConcurrentHashMap();
        concurrentHashMap.put(null,"1");
//        concurrentHashMap.put("a",null);
//        concurrentHashMap.put(null,null);
//        System.out.println(concurrentHashMap.get(null) );
        Map<String,String> map = new HashMap<>();
        map.put(null,null);
        System.out.println("111111111111");
        System.out.println(map.get(null) );
        System.out.println("222222222222222222");

        // 创建一个HashMap
        HashMap<String, String> hashMap = new HashMap<>();

        // 插入键值对，键和值都为null
        hashMap.put(null, null);

        // 输出HashMap
        System.out.println("HashMap: " + hashMap);

        // 获取null键对应的值
        String valueForNullKey = hashMap.get(null);
        System.out.println("Value for null key: " + valueForNullKey);

    }
}
