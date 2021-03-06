import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;

public class SendData {
    private static SendData sendData=new SendData();

    private OutputStream outputStream;
    private ObjectOutputStream objectOutputStream;

    public static SendData getInstance(){
        return sendData;
    }

    public void setOutputStream(Socket socket){
        try {
            outputStream = socket.getOutputStream();
            objectOutputStream=new ObjectOutputStream(outputStream);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void sendChatData(ChatData chatData){
        try {
            objectOutputStream.writeObject(chatData);  
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendPaintData(PaintData paintData){
        try {
            objectOutputStream.writeObject(paintData);  
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    
}