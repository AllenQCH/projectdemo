import java.util.HashMap;
import java.util.Map;

public class Test {
//    public static void main(String[] args)
//    {
//        System.out.println("Hello, world!");
//        int[] ints = new int[]{1, 0, 1, 2, 0, 2, 1, 1, 0, 0};
//        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
//        int count0 = 0;
//        int count1 = 0;
//        int count2 = 0;
//        map.put(0,count0);
//        map.put(1,count1);
//        map.put(2,count2);
//        for(int i=0;i< ints.length;i++){
//            if(0==ints[i]){
//                map.put(0,++count0);
//            }else if(1==ints[i]){
//                map.put(1,++count1);
//            }else if(2==ints[i]){
//                map.put(2,++count2);
//            }else{}
//        }
//        for(int i=0;i< map.get(0);i++){
//            System.out.println(0);
//        }
//        for(int i=0;i< map.get(1);i++){
//            System.out.println(1);
//        }
//        for(int i=0;i< map.get(2);i++){
//            System.out.println(2);
//        }
//
//
//
//
//    }
public static void main(String[] args) {
    int a=100;
    int b = 16;
    System.out.println(a&(b-1));
    System.out.println(a%b);
}
}