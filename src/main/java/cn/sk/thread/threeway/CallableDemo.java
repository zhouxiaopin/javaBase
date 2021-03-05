package cn.sk.thread.threeway;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/**
 * @Deseription
 * 1.Callable和Future创建线程
 * jdk 1.5开始
 * 2.Runnable和Thread的两种方式都有这两个问题：
 *      无法获取子线程的返回值
 *      run方法不可以抛出异常
 * 优点：有返回值、可以抛出异常
 * @Author zhoucp
 * @Date 2021/3/5 15:45
 */
public class CallableDemo implements Callable<Integer> {
    int i = 0;
    public Integer call() throws Exception {
        System.out.println(Thread.currentThread().getName()+"  i的值："+ i);
        TimeUnit.SECONDS.sleep(2);
        return i++; //call方法可以有返回值
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Callable<Integer> callable = new CallableDemo();
        for(int i = 0; i < 10; i++) {
            FutureTask<Integer> futureTask = new FutureTask<Integer>(callable);
            new Thread(futureTask).start();
//            futureTask.get()阻塞线程
            System.out.println("子线程返回值："+futureTask.get());
        }
        System.out.println("主线程...");

    }

}
