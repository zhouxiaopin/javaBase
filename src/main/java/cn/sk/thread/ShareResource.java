package cn.sk.thread;

import java.util.concurrent.TimeUnit;

/**
 * @Deseription 共享资源
 * 1.wait和notify方法,只能被同步监听锁对象来调用,否则报错IllegalMonitorStateException.
 * 那么现在问题来了,Lock机制根本就没有同步锁了,也就没有自动获取锁和自动释放锁的概念.
 * 因为没有同步锁,所以Lock机制不能调用wait和notify方法.
 * @Author zhoucp
 * @Date 2021/3/5 16:38
 */
public class ShareResource {
    private String name;
    private String gender;
    private boolean isEmpty = true;//表示共享资源是否为空的状态
    /**
     * 生产者向共享资源中存储数据
     * @param name
     * @param gender
     */
    public synchronized void  push(String name,String gender) {

        try {
            while (!isEmpty){
//                wait 执行该方法的线程对象释放同步锁,JVM把该线程存放到等待池中,等待其他的线程唤醒该线程
                this.wait();//如果资源不为空,则生产者等待
            }
            this.name = name;
            TimeUnit.SECONDS.sleep(1);//模拟网络延迟
            this.gender = gender;
            System.out.println("生产者生产:"+this.name+"-"+this.gender);
            //生产结束
            this.isEmpty = false; //将共享资源状态设置为不空
//           notify 执行该方法的线程唤醒在等待池中等待的任意一个线程,把线程转到锁池中等待
            this.notify(); //生产完之后唤醒消费者
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    /**
     * 消费从共享资源中取出数据
     */
    public synchronized void popup() {
        try {
            while (this.isEmpty){
                this.wait();//如果资源为空,则消费者等待
            }
            TimeUnit.SECONDS.sleep(1);
            this.isEmpty = true;
            this.notify();//消费完之后唤醒生产者
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("消费者消费:"+this.name+"-"+this.gender);
    }
}
