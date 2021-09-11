package example;

import java.util.ArrayList;

public class TwoThreadPrintFive {
    public static Object lock=new Object();
    public static ArrayList<String> array=new ArrayList<>();
    private static class ThreadA extends Thread{

        @Override
        public void run() {
            synchronized (lock){
                while (true){
                    /*try {
                        sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }*/
                    array.add(Thread.currentThread().getName());
                    if(array.size()!=0&&array.size()%5==0){
                        lock.notify();
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }


    private static class ThreadB extends Thread{
        @Override
        public void run() {
            synchronized (lock){
                while(true){
                    if(array.size()!=0&&array.size()%5==0){
                        System.out.println("array:"+array.size());
                    }
                    lock.notify();
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

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
