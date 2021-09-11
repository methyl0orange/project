package example;
//问题在于线程A长时间得不到资源，那线程B就会一直执行下去
public class selfNotifyExample {
    private static boolean stop=false;
    private static class RunnableA implements Runnable{

        @Override
        public void run() {
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("sleep");
            selfNotifyExample.stop=true;
        }
    }

    private static class RunnableB implements Runnable{

        @Override
        public void run() {
            while (!stop){
                System.out.println("this thread is:"+Thread.currentThread().getName());
            }
            System.out.println("exit:"+Thread.currentThread().getName());
        }
    }

    public static void main(String[] args) {
        Runnable rA=new RunnableA();
        Runnable rB=new RunnableB();
        Thread t1=new Thread(rA,"A");
        Thread t2=new Thread(rB,"B");
        t1.start();
        t2.start();
    }
}
