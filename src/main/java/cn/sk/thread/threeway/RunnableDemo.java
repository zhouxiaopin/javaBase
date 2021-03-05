package cn.sk.thread.threeway;

/**
 * @Deseription
 * 相对Callable和Future方式来说代码更简洁，使用更方便，少了一次转换
 *
 * jdk1.0开始有
 * @Author zhoucp
 * @Date 2021/3/5 15:39
 */
public class RunnableDemo implements Runnable{

    public void run() {
        System.out.println("执行子线程...");
    }

    public static void main(String[] args) {
        RunnableDemo runnableDemo = new RunnableDemo();
//        这一步Thread类的作用就是把run()方法包装成线程执行体，然后依然通过start
//        去告诉系统这个线程已经准备好了可以安排执行。
        new Thread(runnableDemo).start();
        System.out.println("主线程...");
    }
}
