package cn.sk.aop;

/**
 * @Deseription
 * @Author zhoucp
 * @Date 2021/3/12 15:00
 */
public class UserDaoImpl implements UserDao{
    public int add(int a, int b) {
        return a+b;
    }

    public String update(String id) {
        return id;
    }
}
