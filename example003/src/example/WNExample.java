package example;

public class WNExample {
    public static Object lock=new Object();
    private static class ThreadA extends Thread{

        @Override
        public void run() {
            synchronized (lock){
                System.out.println("我是线程A ,我要开始等待了");
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("我是线程A,我被唤醒了 ");
            }
        }
    }


    private static class ThreadB extends Thread{
        @Override
        public void run() {
            synchronized (lock){
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                lock.notify();
            }
        }
    }

    public static void main(String[] args) {
        ThreadA t1=new ThreadA();
        t1.start();
        ThreadB t2=new ThreadB();
        t2.start();
    }
}
