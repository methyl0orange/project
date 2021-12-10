import java.util.Date;
import java.util.concurrent.TimeUnit;

public class SynchronizedTest {
    public static void main(String[] args) {
        Data data=new Data();
        //线程一
        new Thread(()->{
            data.func1();
        },"A").start();
        //休眠1秒
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(()->{
            data.func2();
        },"B").start();
    }
}


class Data{
    public synchronized static void func1(){
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Date nowdate1=new Date();
        System.out.println("func---1    "+nowdate1.getSeconds());
    }
    public synchronized static void func2(){
        Date nowdate2=new Date();
        System.out.println("func---2    " +nowdate2.getSeconds() );
    }
}