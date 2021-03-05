package cn.sk.thread;

/**
 * @Deseription
 * @Author zhoucp
 * @Date 2021/3/5 16:40
 */
public class Producer implements Runnable{
    //共享资源对象
    private LockShareResource resource = null;

    public Producer(LockShareResource resource) {
        this.resource = resource;
    }

    public void run() {
        for (int i = 0; i < 50; i++) {
            if (i % 2 == 0) {
                resource.push("春哥哥", "男");
            } else {
                resource.push("凤姐", "女");
            }
        }
    }

    public static void main(String[] args) {
        LockShareResource sr = new LockShareResource();
        //启动生产者消费者线程
        new Thread(new Producer(sr)).start();
        new Thread(new Consumer(sr)).start();
    }
}
