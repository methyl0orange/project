package example;

public class GroupAddThreadExample {
    public static void main(String[] args) throws InterruptedException {
        Runnable r=new Runnable() {
            @Override
            public void run() {
                System.out.println("当前线程的名字是"+Thread.currentThread().getName());
            }
        };
        ThreadGroup group=new ThreadGroup("测试线程组");
        Thread tA=new Thread(group,r,"A");
        Thread tB=new Thread(group,r,"B");
        Thread tC=new Thread(group,r,"C");
        tA.start();
        tC.start();
        tB.start();
        Thread.sleep(1000);
        System.out.println("当前活跃线程数：" +group.activeCount());
    }
}
