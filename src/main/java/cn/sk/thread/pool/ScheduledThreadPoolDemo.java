package cn.sk.thread.pool;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @Deseription
 * 适用于执行延时或者周期性任务。
 * @Author zhoucp
 * @Date 2021/3/5 14:38
 */
public class ScheduledThreadPoolDemo implements Runnable{
    Integer y = 0;
    public void run() {
        System.out.println(Thread.currentThread().getName()+"=="+y++);
        System.out.println(Thread.currentThread().getName()+"=="+y++);
    }

    public static void main(String[] args) throws InterruptedException {
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(5);
        ScheduledThreadPoolDemo runnable = new ScheduledThreadPoolDemo();
        for(int i = 0; i < 20; i++) {
//            延迟2秒执行
//            executorService.schedule(runnable,2L, TimeUnit.SECONDS);

//            定期执行
//            表示延迟1秒后每3秒执行一次。
            executorService.scheduleAtFixedRate(runnable,1,3,TimeUnit.SECONDS);
        }
        TimeUnit.SECONDS.sleep(10);
        executorService.shutdown();
    }
}
