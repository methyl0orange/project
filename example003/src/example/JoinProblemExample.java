package example;

public class JoinProblemExample {
    private static class MyThread extends Thread{
        @Override
        public void run() {
            try {
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("我是子线程，我结束了");
        }
    }

    public static void main(String[] args) {
        Thread thread=new MyThread();
        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("我是主线程，我结束了");
    }
}
