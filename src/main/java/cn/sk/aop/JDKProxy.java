package cn.sk.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

/**
 * @Deseription
 *   第一种有接口情况，使用jdk动态代理
 * @Author zhoucp
 * @Date 2021/3/12 15:02
 */
public class JDKProxy {
    public static void main(String[] args) {
        //创建接口实现类代理对象
        Class[] interfaces = {UserDao.class};
        UserDaoImpl userDao = new UserDaoImpl();
        UserDao o = (UserDao) Proxy.newProxyInstance(JDKProxy.class.getClassLoader(), interfaces,
                new UserDaoProxy(userDao));
        System.out.println(o.add(1,2));
    }
}
//    创建代理对象代码
class  UserDaoProxy implements InvocationHandler{
//    1.创建的是谁的代理对象，把谁传过来
    //有参构造传递
    private Object obj;
    public UserDaoProxy(Object obj){
        this.obj = obj;
    }
    //增强的逻辑
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//        方法之前
        System.out.println("方法之前执行...."+method.getName()+":参数"+ Arrays.toString(args));
//        被增强的方法执行
        Object res = method.invoke(obj, args);
//        方法之后
        System.out.println("方法之后执行...."+obj);
        return res;
    }
}