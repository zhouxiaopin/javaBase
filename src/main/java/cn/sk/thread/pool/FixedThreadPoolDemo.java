package cn.sk.thread.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @Deseription
 * 1.newFixedThreadPool：创建一个固定大小的线程池，因为采用无界的阻塞队列，
 * 所以实际线程数量永远不会变化，适用于负载较重的场景，对当前线程数量进行限制。
 * （保证线程数可控，不会造成线程过多，导致系统负载更为严重）
 *  2.创建一个定长线程池，可控制线程最大并发数，超出的线程会在队列中等待。
 *  3.定长线程池的大小最好根据系统资源进行设置。如Runtime.getRuntime().availableProcessors()
 * @Author zhoucp
 * @Date 2021/3/5 14:33
 */
public class FixedThreadPoolDemo implements Runnable{
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
//        因为线程池大小为5，每个任务sleep 2秒，所以每两秒打印5个数字。
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        FixedThreadPoolDemo fixedThreadPoolDemo = new FixedThreadPoolDemo();
        for(int i = 0; i < 20; i++) {
            executorService.execute(fixedThreadPoolDemo);
        }
        System.out.println(Runtime.getRuntime().availableProcessors());
        executorService.shutdown();
    }
}
