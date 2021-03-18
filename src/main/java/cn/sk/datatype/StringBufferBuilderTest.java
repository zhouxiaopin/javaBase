package cn.sk.datatype;

import org.junit.Test;

/**
 * @Deseription
 * @Author zhoucp
 * @Date 2021/3/10 10:10
 */
public class StringBufferBuilderTest {
    /*
    * String、StringBuffer、StringBuilder
    * String:不可变的字符序列 ，底层使用char[]存储
    * StringBuffer：可变的字符序列：线程安全的，效率低，底层使用char[]存储
    * StringBuilder（1.5）：可变的字符序列：线程不安全的，效率高，底层使用char[]存储
    *
    * 源码分析
    *   String str = new String();//new char[0];
    *   String str1 = new String("abc");//new char[]{'a','b','c'};
    *
    *   StringBuffer sb1 = new StringBuffer();//new char[16];底层创建了一个长度是16的数组
    *   sb1.append('a')；//value[0]='a'
    *   sb1.append('B')；//value[0]='B'
    *   StringBuffer sb2 = new StringBuffer("abc")"";//new char["abc".length+16];底层创建了一个长度是19的数组
    *   扩容问题：如果要添加的数据底层数组放不下，那就学院扩容底层的数组
    *           默认情况下，扩容为原来容量的2倍+2，同时将原有数组中的元素复制到新的数组中
    *       开发中建议大家使用StringBuffer(int capacity) 或 StringBuilder(int capacity)
    *
    *  效率 StringBuilder》StringBuffer》String
    * */
    @Test
    public void test1(){
        StringBuffer sb1 = new StringBuffer("abc");
        sb1.setCharAt(0,'m');
        System.out.println(sb1.toString());
        StringBuffer sb2 = new StringBuffer("abc");
        System.out.println(sb2.length());//3
    }
}
