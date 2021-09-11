package example;

public class lamda {
    public static void main(String[] args) {
        Thread thread = new Thread(() -> System.out.println("当前运行的线程是：" + Thread.currentThread().getName()));
        thread.start();
        System.out.println("main线程中执行的代码：" + Thread.currentThread().getName());
    }
}
