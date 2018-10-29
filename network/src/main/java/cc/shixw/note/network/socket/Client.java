package cc.shixw.note.network.socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @author shixianwei
 * @date 2018/10/29 11:17
 */
public class Client {

    public static void main(String[] args) {
        String serverName = "127.0.0.1";
        int port = 9999;
        System.out.println("连接主机："+serverName+",端口号："+port);
        try {
            Socket client = new Socket(serverName,port);
            System.out.println("远程主机地址："+client.getRemoteSocketAddress());
            DataOutputStream out = new DataOutputStream(client.getOutputStream());

            out.writeUTF("Hello from "+client.getLocalSocketAddress());

            DataInputStream in = new DataInputStream(client.getInputStream());
            System.out.println("服务端响应："+in.readUTF());
            client.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
