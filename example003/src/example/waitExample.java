package example;

public class waitExample {
    public static void main(String[] args) throws InterruptedException {
        String s="123";
        System.out.println("获取对象锁之前的代码");
        synchronized (s){
            System.out.println("锁进入等待的代码");
            s.wait();
            System.out.println("锁进入等待后的代码");

        }
        System.out.println("释放锁之后的代码");
    }
}
