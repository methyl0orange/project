public class Thread1 implements Runnable,Observer {
    @Override
    public void exceptionHandler() {
        System.out.println("thread1 rockback---");

    }

    @Override
    public void run() {

        System.out.println("thread1 run");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("thread1 end");
    }
}
