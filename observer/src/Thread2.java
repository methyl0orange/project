public class Thread2 implements Runnable,Observer {
    private static Thread CURRENT_THREAD;
    private static volatile boolean FLAG=false;
    @Override
    public void exceptionHandler() {
        FLAG=true;
        CURRENT_THREAD.interrupt();
        System.out.println("thread2 end");

    }

    @Override
    public void run() {
        CURRENT_THREAD=Thread.currentThread();
        System.out.println("thread2 run");
        int count=0;
        while (!FLAG){
            System.out.println(count);
            count++;
        }
        System.out.println("thread2 rockback--");

    }
}
