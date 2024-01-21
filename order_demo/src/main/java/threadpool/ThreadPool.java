package threadpool;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

public class ThreadPool {
    @Autowired
    private  ThreadPoolTaskExecutor threadPoolTaskExecutor;
}
