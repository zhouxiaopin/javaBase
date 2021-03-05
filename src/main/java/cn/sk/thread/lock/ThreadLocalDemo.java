package cn.sk.collection.thread.lock;

/**
 * @Deseription
 * 1.ThreadLocal是除了加锁这种同步方式之外的一种保证一种规避多线程访问出现线程不安全的方法
 * 2.ThreadLocal是JDK包提供的，它提供线程本地变量，如果创建一个ThreadLocal变量，
 * 那么访问这个变量的每个线程都会有这个变量的一个副本，在实际多线程操作的时候，
 * 操作的是自己本地内存中的变量，从而规避了线程安全问题，
 * 这里的副本不是什么引用或者啥的，而是new出来的一个新对象，每个线程只维护自己的对象。
 * 3.早在JDK 1.2的版本中就提供java.lang.ThreadLocal，ThreadLocal为解决多线程程序
 * 的并发问题提供了一种新的思路。使用这个工具类可以很简洁地编写出优美的多线程程序
 * 4.ThreadLocal与Synchronized区别
 * 相同
 *      ThreadLocal和线程同步机制相比有什么优势呢？ThreadLocal和线程同步机制都是为
 *      了解决多线程中相同变量的访问冲突问题。
 * 5.同步机制采用了“以时间换空间”的方式。ThreadLocal采用了“以空间换时间”的方式
 * @Author zhoucp
 * @Date 2021/3/4 10:45
 */
public class ThreadLocalDemo implements Runnable{
    private ThreadLocal<Integer> num = new ThreadLocal<Integer>();

    public void run() {
        for(int i = 0; i < 5; i++) {
            num.set(i);
//            try {
//                TimeUnit.SECONDS.sleep(1L);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            System.out.println(Thread.currentThread().getName()+"-----"+num.get());
        }
        num.remove();//清除本地内存中的本地变量
    }

    public static void main(String[] args) {
        ThreadLocalDemo threadLocalDemo = new ThreadLocalDemo();
        for(int i = 0; i < 5; i++) {
            new Thread(threadLocalDemo,"Thread"+i).start();
        }
    }

}
