package cn.sk.thread.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @Deseription
 * 1、newCachedThreadPool：用来创建一个可以无限扩大的线程池，适用于负载较轻的场景，执行短期异步任务。
 * （可以使得任务快速得到执行，因为任务时间执行短，可以很快结束，也不会造成cpu过度切换）
 * 线程池为无限大，当执行第二个任务时第一个任务已经完成，会复用执行第一个任务的线程，而不用每次新建线程。

 * @Date 2021/3/5 14:32
 */
public class CachedThreadPoolDemo implements Runnable{
    Integer y = 0;
    public void run() {
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+"=="+y++);
    }
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        CachedThreadPoolDemo cachedThreadPoolDemo = new CachedThreadPoolDemo();
        for(int i = 0; i < 200; i++) {
            executorService.execute(cachedThreadPoolDemo);
        }
        executorService.shutdown();

    }


}
