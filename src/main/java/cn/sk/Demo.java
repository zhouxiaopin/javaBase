package cn.sk;

import org.junit.Test;

/**
 * @Deseription
 * @Author zhoucp
 * @Date 2021/3/18 10:39
 */
public class Demo {
    @Test
    public void test2(){
//        int i = 2;
//        int s = 0;
//
//       switch (i){
//           case 1:
//               s = s+i*2;
//           case 2:
//               s = s+i*3;//6
//           case 3:
//               s = s+i*4;//8
//       }
//        System.out.println(s);
        int i = 2;
        int s = 0;

        System.out.println(a());
    }
    public int a(){
        int i=1;
        try {
            return i++;
        }finally {
            return i++;
        }
    }
}
