package classLoader;

import sun.net.spi.nameservice.dns.DNSNameService;

import java.io.File;
import java.sql.DriverManager;

public class Demo {
    public static void main(String[] args) {
        //jre/lib/rt
        ClassLoader classLoader = Object.class.getClassLoader();
        System.out.println(classLoader);
        //jre/lib/ext
        ClassLoader classLoader1 = DNSNameService.class.getClassLoader();
        System.out.println(classLoader1);

        //自定义加载器默认父加载器
        ClassLoader classLoader2 = Demo.class.getClassLoader();
        System.out.println(classLoader2);
        System.out.println(File.separator);

        ClassLoader classLoader3 = DriverManager.class.getClassLoader();
        System.out.println(classLoader3);
    }

}
