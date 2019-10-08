

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class PaintChatServer {

    public static final int PORT = 7777;    
    public static void main(String args[]) {
        ServerSocket serverSocket = null;

        try {
            serverSocket = new ServerSocket(PORT);  
            while(true){
                Socket socket = serverSocket.accept();

                UserList.list.add(socket);

             

                new ReceiveThread(socket).start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

