package socket;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class SocketServerContinue {

    private BufferedWriter writer;

    private BufferedReader reader;

    public static void main(String[] args) {
        SocketServerContinue socketServer = new SocketServerContinue();
        socketServer.startServer();
    }

    private void startServer() {
        ServerSocket serverSocket = null;
        Socket socket = null;
        try {
            // 端口号只要不冲突就行
            serverSocket = new ServerSocket(9898);
            System.out.println("server started..");
            while (true) {
                // 进入阻塞状态，等待客户端接入
                socket = serverSocket.accept();
                manageConnection(socket);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                assert socket != null;
                socket.close();
                serverSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void manageConnection(final Socket socket) {
        new Thread(new Runnable() {
            public void run() {
                try {
                    System.out.println("client " + socket.hashCode() + " connected");
                    // 从socket中读取数据
                    reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
                    String receiveMsg;
                    while ((receiveMsg = reader.readLine()) != null) { // 以"\n"结束
                        System.out.println("client " + socket.hashCode() + ":" + receiveMsg);
                        Person person = new Person();
                        person.setBirthday(new Date());
                        person.setClassId("B170404");
                        person.setId("B17040417");
                        person.setName("yll");
                        writer.write("server reply:" + person.toString() + "\n");
                        writer.flush();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    try {
                        reader.close();
                        writer.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }

}