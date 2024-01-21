package com.threadpool.demo.config;

/**
 * 创建一个通用的异步任务类AsyncTask和工具类AsyncTaskUtil
 */
public class AsyncTask implements Runnable {

    // 服务对象
    private Object object;
    // 调用方法
    private String methodName;
    // 方法参数(具有顺序性)
    private Object[] args;

    public AsyncTask(Object object, String methodName, Object[] args) {
        this.object = object;
        this.methodName = methodName;
        this.args = args;
    }

    @Override
    public void run() {
        try {
            ReflectionUtil.invokeMethod(object, methodName, args);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
