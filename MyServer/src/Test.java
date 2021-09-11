import java.net.InetAddress;
import java.net.UnknownHostException;

public class Test {
    public static void main(String[] args) {
        try {
            InetAddress inetAddress=InetAddress.getByName("www.baidu.com");
            System.out.println(inetAddress.getHostName());
            System.out.println(inetAddress.getHostAddress());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
