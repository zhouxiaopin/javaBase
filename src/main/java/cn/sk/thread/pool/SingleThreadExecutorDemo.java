package cn.sk.thread.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @Deseription
 * 1.创建一个单线程的线程池，适用于需要保证顺序执行各个任务
 * 2.创建一个单线程化的线程池，它只会用唯一的工作线程来执行任务，
 * 保证所有任务按照指定顺序(FIFO=( First Input First Output), LIFO, 优先级)执行
 * @Author zhoucp
 * @Date 2021/3/5 14:36
 */
public class SingleThreadExecutorDemo implements Runnable{
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
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        SingleThreadExecutorDemo runnable = new SingleThreadExecutorDemo();
        for(int i = 0; i < 20; i++) {
            executorService.execute(runnable);
        }
        executorService.shutdown();

    }
}
