package example;

import java.util.ArrayList;
import java.util.Random;

/*
* 厨师做馒头，剩余馒头超过10，停止。每秒做一个，三个食客吃馒头，
* 如果发现有馒头可以吃随机吃一到五个，如果馒头不足
* 食客需求那么食客等待。
* */
public class Streamedbuns {
    private static Integer streamedBunsNum=0;
    private static Object lock=new Object();
    private static ArrayList<Integer> coustomer=new ArrayList<>();
    private static Integer tatol=0;

    private static class DoStream extends Thread{

        @Override
        public void run() {
            while(streamedBunsNum<10){
                synchronized (lock){
                    try {
                        sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    streamedBunsNum++;
                    System.out.println("馒头还剩："+streamedBunsNum);
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

    private static class EatStream extends Thread{

        @Override
        public void run() {
            synchronized (lock){
                while(true){
                    Random r=new Random();
                    for (int i = 0; i < 3; i++) {
                        coustomer.set(i,r.nextInt(5)+1);
                    }
                    tatol=0;
                    for (int i = 0; i < 3; i++) {
                        System.out.println(coustomer.get(i));
                        tatol+=coustomer.get(i);
                    }
                    tatol=tatol%5+1;
                    if(streamedBunsNum>tatol){
                        streamedBunsNum-=tatol;
                        System.out.println("吃了："+tatol+"个。"+"还剩："+streamedBunsNum);
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
        coustomer.add(0);
        coustomer.add(0);
        coustomer.add(0);
        DoStream doStream=new DoStream();
        EatStream eatStream=new EatStream();
        doStream.start();
        eatStream.start();
    }
}
