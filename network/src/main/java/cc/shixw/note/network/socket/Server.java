package cc.shixw.note.network.socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

/**
 * @author shixianwei
 * @date 2018/10/29 11:17
 */
public class Server extends Thread {

    private ServerSocket serverSocket;

    public Server(int port) throws IOException {
        serverSocket = new ServerSocket(port);
        serverSocket.setSoTimeout(10000);
    }

    @Override
    public void run() {
        while (true){
            System.out.println("等待远程连接，端口号为："+serverSocket.getLocalPort()+" ....");
            try {
                Socket socket = serverSocket.accept();
                System.out.println("远程主机地址："+socket.getRemoteSocketAddress());
                DataInputStream in =  new DataInputStream(socket.getInputStream());
                System.out.println(in.readUTF());
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());
                out.writeUTF("连接完事："+serverSocket.getLocalSocketAddress());
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
                break;
            }catch (Exception e){
                e.printStackTrace();
                break;
            }
        }
    }

    public static void main(String[] args) {

        try {
            Server server = new Server(9999);
            server.run();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
