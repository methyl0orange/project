import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class MyServer {
    public static void main(String[] args) {
        try {
            ServerSocket ss=new ServerSocket(6666);
            Socket socket=ss.accept();
            String str="";
            InputStream is=socket.getInputStream();
            byte[] b=new byte[1024];
            int i=is.read();
            while (i>0){
                str+=new String(b,0,i);
                i=is.read();
            }
            System.out.println("客户端："+str);
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
