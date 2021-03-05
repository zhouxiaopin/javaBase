package cn.sk.collection;

/**
 * @Deseription 静态内部类实现模式（线程安全，调用效率高，可以延时加载）
 * @Author zhoucp
 * @Date 2021/2/26 17:52
 */
public class SingletonDemo3 {

    private static class SingletonClassInstance{
        private static final SingletonDemo3 instance=new SingletonDemo3();
    }

    private SingletonDemo3(){}

    public static SingletonDemo3 getInstance(){
        return SingletonClassInstance.instance;
    }

}