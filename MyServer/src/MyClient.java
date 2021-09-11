import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class MyClient {
    public static void main(String[] args) {
        try {
            Socket socket=new Socket("127.0.0.1",6666);
            OutputStream os=socket.getOutputStream();
            os.write("你干嘛呢".getBytes(StandardCharsets.UTF_8));
            os.flush();
            os.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
