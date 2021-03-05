package cn.sk.thread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Deseription
 * 1. 从Java5开始,可以:
 *  使用Lock机制取代synchronized 代码块和synchronized 方法.
 *  使用Condition接口对象的await,signal,signalAll方法取代Object类中的wait,notify,notifyAll方法.
 * @Author zhoucp
 * @Date 2021/3/5 17:08
 */
public class LockShareResource {
    private String name;
    private String gender;
    private boolean isEmpty = true;//表示共享资源是否为空的状态

    private Lock lock = new ReentrantLock(); //创建锁对象
    private Condition condition = lock.newCondition(); //获取Condition接口的对象
    /**
     * 生产者向共享资源中存储数据
     * @param name
     * @param gender
     */
    public void  push(String name,String gender) {
        lock.lock();//加锁
        try {
            while (!isEmpty){
//                wait 执行该方法的线程对象释放同步锁,JVM把该线程存放到等待池中,等待其他的线程唤醒该线程
//                this.wait();//如果资源不为空,则生产者等待
                condition.await();//替换上面的wait()
            }
            this.name = name;
            TimeUnit.SECONDS.sleep(1);//模拟网络延迟
            this.gender = gender;
            System.out.println("生产者生产:"+this.name+"-"+this.gender);
            //生产结束
            this.isEmpty = false; //将共享资源状态设置为不空
//           notify 执行该方法的线程唤醒在等待池中等待的任意一个线程,把线程转到锁池中等待
//            this.notify(); //生产完之后唤醒消费者
            condition.signal();//替换上面的notify()
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();//释放锁
        }

    }

    /**
     * 消费从共享资源中取出数据
     */
    public void popup() {
        lock.lock();//加锁
        try {
            while (this.isEmpty){
//                this.wait();//如果资源为空,则消费者等待
                condition.await();//替换上面的wait()
            }
            TimeUnit.SECONDS.sleep(1);
            this.isEmpty = true;
//            this.notify();//消费完之后唤醒生产者
            condition.signal();//替换上面的notify()
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();//释放锁
        }
        System.out.println("消费者消费:"+this.name+"-"+this.gender);
    }
}
