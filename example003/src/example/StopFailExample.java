package example;

public class StopFailExample {
    private static class StopRunnable implements Runnable{

        //表示线程是不是应该停止了
        private volatile  boolean shouldStop=false;

        public boolean isShouldStop() {
            return shouldStop;
        }

        public void setShouldStop(boolean shouldStop) {
            this.shouldStop = shouldStop;
        }

        @Override
        public void run() {
            int num=0;
            String threadName=Thread.currentThread().getName();
            while(!shouldStop){
                System.out.println(threadName+"当前时间戳是:"+System.currentTimeMillis());
                num++;
            }
            System.out.println("我已经运行完了");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        StopRunnable stopRunnable=new StopRunnable();
        Thread t=new Thread(stopRunnable);
        t.start();
        Thread.sleep(2000);
        stopRunnable.setShouldStop(true);
    }

}
