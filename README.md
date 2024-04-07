# projectdemo
springboot项目从0开始


第一个分支：新建一个springboot项目
第二个分支：将mybatisplus和mysql以及逆向工程加到项目中
demo_20231220分支：将springboot与redis、lettuce集成，并写了一个redistemplate的简单示例，后面需要升级
demo_20231222分支：集成redis、lettuce后，封装了redisutil方法
demo_20231228分支：集成了swagger（knife3.03版本）knife是swagger的升级版本
demo_20240108分支：实现了静态代理和动态代理：包括基于jdk（接口形式）和cglib（类）两种方式

demo_20240117分支：测试几个线程的使用：参考：https://blog.csdn.net/ThinkWon/article/details/102541990
demo_20240121分支：1、写了通过threadpooltaskexecutors的封装的多线程
                  2、写了通过springboot注解实现的多线程
                  参考文章：https://blog.csdn.net/lingerlan510/article/details/122322588
                  参考文章：https://cloud.tencent.com/developer/article/1984291
                  创建order_demo中的多线程相关的类
demo_20240122分支：写了单例模式的demo         
demo_20240217分支：引入rocketmq，并写了一个简单的demo
demo_20240323分支：加入一个test_mybatis_plus的module,后期如果有一个单纯的逆向生成的工程可以参考这个
demo_20240407分支：新加入一个test_threadpool的module,需要实现功能如下:
                  1、先做一个批量插入的功能,要用三种方式：a、for循环逐个插入，b、sql insertbatch插入，c、多线程+sql insertbatch插入
                  2、用countdownlatch多次查询其他表，如果为空，则做什么操作
