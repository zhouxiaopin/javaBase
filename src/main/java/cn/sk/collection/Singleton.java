package cn.sk.collection;

/**
 * @Deseription
 * @Author zhoucp
 * @Date 2021/2/26 17:41
 */
public class Singleton {
    private static Singleton instance = null;
    private Singleton(){}
    public static Singleton getInstance(){
        if(null == instance) {
            instance = new Singleton();
        }
        return instance;
    }
}
