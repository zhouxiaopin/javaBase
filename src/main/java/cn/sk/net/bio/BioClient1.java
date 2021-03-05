package cn.sk.net.bio;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @Deseription
 * @Author zhoucp
 * @Date 2021/3/5 10:05
 */
public class BioClient1  implements Runnable{
    private static int port = 9000;
    public static void main(String[] args) throws IOException {
        BioClient1 bioClient1 = new BioClient1();
        for(int i = 0; i < 10; i++) {
           new Thread(bioClient1,"线程"+i).start();
        }

    }

    public void run() {
        Socket socket = null;
        OutputStream outputStream = null;
        InputStream inputStream = null;
        try {
            socket = new Socket("localhost",port);
            outputStream = socket.getOutputStream();
            System.out.println("====bio客户端启动成功=====");
            outputStream.write((Thread.currentThread().getName()+"客户端发送的数据")
                    .getBytes("UTF-8"));
            inputStream = socket.getInputStream();
            byte[] bytes = new byte[1024];
            int len = 0;
            while ((len = inputStream.read(bytes))!=-1){
                System.out.println(new String(bytes,0,len));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                inputStream.close();
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }
}
