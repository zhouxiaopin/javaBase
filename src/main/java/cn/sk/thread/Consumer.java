package cn.sk.thread;

/**
 * @Deseription
 * @Author zhoucp
 * @Date 2021/3/5 16:42
 */
public class Consumer implements Runnable{
    //共享资源对象
    private LockShareResource resource;

    public Consumer(LockShareResource resource) {
        this.resource = resource;
    }
    public void run() {
        for (int i = 0; i < 50; i++) {
            resource.popup();
        }
    }
}
