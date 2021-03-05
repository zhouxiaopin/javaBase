package cn.sk.net.bio;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Deseription
 * 同步阻塞IO（BIO）
 * 1.BIO：同步并阻塞，服务器的实现模式是一个连接一个线程，这样的模式很明显的一个缺陷是：
 * 由于客户端连接数与服务器线程数成正比关系，可能造成不必要的线程开销，严重的还将导致服务器内存溢出。
 * 当然，这种情况可以通过线程池机制改善，但并不能从本质上消除这个弊端。
 * 应用场景：并发连接数不多时采用BIO，因为它编程和调试都非常简单，但如果涉及到高并发的情况，
 * 应选择NIO或AIO，更好的建议是采用成熟的网络通信框架Netty。
 *
 * 2.在活动连接数不是特别高（小于单机1000）的情况下，这种模型是比较不错的，可以让每一个连接专注于自己的
 * I/O 并且编程模型简单，也不用过多考虑系统的过载、限流等问题。线程池本身就是一个天然的漏斗，可以缓冲
 * 一些系统处理不了的连接或请求。但是，当面对十万甚至百万级连接的时候，传统的 BIO 模型是无能为力的。因此，
 * 我们需要一种更高效的 I/O 处理模型来应对更高的并发量。

 * @Author zhoucp
 * @Date 2021/3/5 9:22
 */
public class BioServer1 implements Runnable{
    private  Socket curSocket;
    private static int port = 9000;

    public BioServer1(Socket socket){
        this.curSocket = socket;
    }

    public static void serverInit() throws IOException {
        ServerSocket serverSocket = new ServerSocket(port);
        System.out.println("====bio服务端启动成功=====");
        System.out.println("====等待客户端连接=====");
        while (true){

            Socket socket = serverSocket.accept();
            BioServer1 bioDemo1 = new BioServer1(socket);
            new Thread(bioDemo1).start();
        }

    }
    public static void main(String[] args) throws IOException {
        serverInit();

    }
//    传统 BIO
    public void run() {
        InputStream inputStream = null;
        OutputStream outputStream = null;
        try {
            inputStream = this.curSocket.getInputStream();
            outputStream = this.curSocket.getOutputStream();
            byte[] bytes = new byte[1024];
            int len = 0;
            while ((len = inputStream.read(bytes))!=-1){
                System.out.println(new String(bytes,0,len));
                outputStream.write(("服务端返回:"+Thread.currentThread().getName()).getBytes("UTF-8"));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                outputStream.close();
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
