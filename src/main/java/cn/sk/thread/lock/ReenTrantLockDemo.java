package cn.sk.collection.thread.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Deseription
 * 1.ReentrantLock它是JDK 1.5之后提供的API层面的互斥锁，需要lock()和unlock()方法配合try/finally语句块来完成。
 * 2.使用ReentrantLock。如果Thread1不释放，Thread2等待了很长时间以后，可以中断等待，转而去做别的事情。
 * 3.ReentrantLock 构造器的一个参数是boolean值，它允许您选择想要一个公平（fair）锁，还是一个
 * 不公平（unfair）锁。公平锁：使线程按照请求锁的顺序依次获得锁, 但是有成本;不公平锁：则允许讨价还价
 * 4.ReentrantLock可以同时绑定多个Condition对象，只需多次调用newCondition方法即可
 * 5.适用场景：时间锁等候、可中断锁等候、无块结构锁、多个条件变量或者锁投票
 * @Author zhoucp
 * @Date 2021/3/4 10:07
 */
public class ReenTrantLockDemo implements Runnable{
    Lock lock = new ReentrantLock();//不公平锁
//    Lock lock = new ReentrantLock(true);//公平锁
//    public void run() {
//        lock.lock();
//        try {
//            System.out.println("ReenTrantLockDemo---"+Thread.currentThread().getName());
//        }finally {
//            lock.unlock();
//        }
//    }
    public void run() {
        boolean isLock = false;
        try {
            isLock = lock.tryLock(3L, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if(isLock) {
            try {
                TimeUnit.SECONDS.sleep(1L);
                System.out.println("ReenTrantLockDemo---"+Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }else{
            System.out.println("没有获得锁---"+Thread.currentThread().getName());
        }

    }
    public static void main(String[] args){
        ReenTrantLockDemo reenTrantLockDemo = new ReenTrantLockDemo();
        for(int i = 0; i < 10; i++) {
            new Thread(reenTrantLockDemo,"Thread"+i).start();
        }
    }
}
