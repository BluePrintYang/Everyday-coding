package socket;

import java.beans.Encoder;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ServerSocketTest {
    public static void main(String[] args) throws IOException {
    // 初始化服务端socket并且绑定9999端口
        ServerSocket serverSocket = new ServerSocket(9999);
        System.out.println("服务器已启动");
    //创建一个线程池
        ExecutorService executorService = Executors.newFixedThreadPool(100);
        while (true) {
        //等待客户端的连接
            final Socket socket = serverSocket.accept();
            System.out.println("IP:"+socket.getPort()+"已连接");
            Runnable runnable = new Runnable() {
                public void run() {
                    BufferedReader bufferedReader = null;
                    try {
                        bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
                        //读取一行数据
                        String str;
                        //通过while循环不断读取信息，
                        while ((str = bufferedReader.readLine()) != null) {
                            //输出打印
                            System.out.println("time:" + new Date());
                            System.out.println("客户端" + socket.getPort() + "说：" + str);
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            };
            executorService.submit(runnable);
        }
    }
}
