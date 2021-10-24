import java.util.concurrent.CompletableFuture;

public class Demo {
    public static void main(String[] args) throws InterruptedException {
        Subject subject=new SubjectHandler();
        Thread1 thread1=new Thread1();
        Thread2 thread2=new Thread2();
        subject.add(thread1);
        subject.add(thread2);

        CompletableFuture.supplyAsync(()->{
            new Thread(thread1).start();
            try {
                Thread.sleep(10);
                int a=1/0;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return true;
        }).exceptionally((error)->{
            subject.notifyAllSubject();
            return false;
        });

        CompletableFuture.supplyAsync(()->{
            new Thread(thread2).start();
            return true;
        }).exceptionally((error)->{
            subject.notifyAllSubject();
            return false;
        });
        Thread.sleep(6*1000);
    }
}
