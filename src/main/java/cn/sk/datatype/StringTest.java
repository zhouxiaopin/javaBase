package cn.sk.datatype;

import org.junit.Test;

/**
 * @Deseription
 *  字符串是不可变性，值传递，字符串每次拼接操作都是重新声明对象。
 *  字符串底层是 char[] 存储数据
 *  字面量声明字符串都是放在常量池
 *  字符串是不可变的字符序列
 * @Author zhoucp
 * @Date 2021/3/10 9:36
 */
public class StringTest {

    /*
    * 结论
    * 1.常量与常量的拼接结果在(方法区常量池)常量池中且常量池中不会存在相同内容
    *   的常量，
    * 2.只要其中有一个是变量，结果就在堆中
    * 3.如果拼接的结果调用intern()方法，返回值放在常量池中
    * */
    @Test
    public void test1(){
        String s1 = "javaEE";//字面量声明字符串都是放在常量池
        String s2 = "hadoop";
        s1.indexOf("E");

        String s3 = "javaEEhadoop";
        String s4 = "javaEE"+"hadoop";
        String s5 = s1+"hadoop";
        String s6 = "javaEE"+s2;
        String s7 = s1+s2;
        String s8 = (s1+s2).intern();

        final String s9 = "javaEE";// final 就是常量
        String s10 = s9+"hadoop";//.常量与常量的拼接结果在(方法区常量池)常量池

        System.out.println(s3 == s4);//true
        System.out.println(s3 == s5);//false
        System.out.println(s3 == s6);//false
        System.out.println(s3 == s7);//false
        System.out.println(s3 == s8);//true
        System.out.println(s3 == s10);//true
    }

}
