package cn.sk.thread.threeway;

/**
 * @Deseription
 * 1.只需要创建一个类去继承Thread类然后重写run方法，在main方法中调用该类实例对象
 *      的start方法即可实现多线程并发
 * 2.最简洁方便的，直接就可以start，不需要任何转换 ，但是有一个很不好的地方就是继承了
 *      Thread类后由于java的单继承机制，就不可以继承其他的类了，而如果实现的是接口，
 *      就可以实现多个接口，使开发更灵活
 * @Author zhoucp
 * @Date 2021/3/5 15:33
 */
public class ThreadDemo extends Thread{
    @Override
    public void run() {
        super.run();
        System.out.println("执行子线程...");
    }

    public static void main(String[] args) {
        ThreadDemo threadDemo = new ThreadDemo();
        /*
        * 这里还有一个需要注意的点就是main方法中应该调用的是myThread的start方法，
        * 而不是run()方法。调用start()方法是告诉CPU此线程已经准备就绪可以执行，
        * 进而系统有时间就会来执行其run()方法。而直接调用run()方法，则不是异步执行，
        * 而是等同于调用函数般按顺序同步执行，这就失去了多线程的意义了。
        * */
        threadDemo.start();
        System.out.println("主线程...");
    }
}
