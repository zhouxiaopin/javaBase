package cn.sk.collection.thread.lock;

/**
 * @Deseription
 * 1.它是java语言的关键字，是原生语法层面的互斥，需要jvm实现
 * 2.使用synchronized。如果Thread1不释放，Thread2将一直等待，
 * 不能被中断。synchronized也可以说是Java提供的原子性内置锁机制。
 * 内部锁扮演了互斥锁（mutual exclusion lock ，mutex）的角色，
 * 一个线程引用锁的时候，别的线程阻塞等待
 * 3.是非公平锁 非公平锁在锁被释放时，任何一个等待锁的线程都有机会获得锁（就是不是按访问顺序获得锁的）
 * 4.Synchronized进过编译，会在同步块的前后分别形成monitorenter和monitorexit这个两个字节码指令。
 * 在执行monitorenter指令时，首先要尝试获取对象锁。如果这个对象没被锁定，或者当前线程已经拥有了那个对象锁，
 * 把锁的计算器加1，相应的，在执行monitorexit指令时会将锁计算器就减1，当计算器为0时，锁就被释放了。
 * 如果获取对象锁失败，那当前线程就要阻塞，直到对象锁被另一个线程释放为止。
 * @Author zhoucp
 * @Date 2021/3/4 9:58
 */
public class SynchronizedDemo implements Runnable{

    public void run() {
//        非公平锁 不是按顺序的
        synchronized (SynchronizedDemo.this){
            System.out.println("SynchronizedDemo---"+Thread.currentThread().getName());
        }
    }

    public static void main(String[] args) {
        SynchronizedDemo synchronizedDemo = new SynchronizedDemo();
        for(int i = 0; i < 20; i++) {
          new Thread(synchronizedDemo,"Thread"+i).start();
        }
    }
}
