package cn.sk.collection.thread.lock;

import java.util.concurrent.TimeUnit;

/**
 * @Deseription
 * 1.主要是保证内存可见性和防止指令重排序
 * 2.volatile关键字的作用很简单，就是一个线程在对主内存的某一份数据进行更改时，改完之后会立刻刷新到主内存。
 * 并且会强制让缓存了该变量的线程中的数据清空，必须从主内存重新读取最新数据。
 * @Author zhoucp
 * @Date 2021/3/4 10:33
 */
public class VolatileDemo  implements Runnable{
    private volatile int i = 0;
    public void run() {
//        不保证原子性（有重复）
        try {
            TimeUnit.SECONDS.sleep(1L);
            System.out.println(i++);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        VolatileDemo volatileDemo = new VolatileDemo();
        for(int i = 0; i < 20; i++) {
            new Thread(volatileDemo,"Thread"+i).start();
        }
//        List<Integer> arraylist = Arrays.asList(2, 5, 2, 3, 2, 4);
//        Set<Integer> hashset_temp = new LinkedHashSet<Integer>(arraylist);
//        arraylist  = new ArrayList<Integer>(hashset_temp);
//        System.out.println(arraylist);
    }
}
