package example;

public class CurrentNotStopExample {
    private static class MyThread1 extends Thread{
        @Override
        public void run() {
            try {
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("我是子线程1，我结束了");
        }
    }
    private static class MyThread2 extends Thread{
        @Override
        public void run() {
            Thread thread=new MyThread1();
            thread.start();
            try {
                thread.join();//内加时间表示只等待那麽长时间
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("我是子线程2，我结束了");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t=new MyThread2();
        t.start();
    }
}
