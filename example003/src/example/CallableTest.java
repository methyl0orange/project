package example;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CallableTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Callable<Integer> callable = () -> {
            int num = 0;
            for (int i = 1; i <= 100; i++) {
                num += i;
            }
            System.out.println("I am " + Thread.currentThread().getName() + ", my result is " + num);
            return num;
        };
        Set<FutureTask<Integer>> futureTasks = new HashSet<>();
        for (int i = 0; i < 10; i++) {
            FutureTask<Integer> futureTask = new FutureTask<>(callable);
            futureTasks.add(futureTask);
            new Thread(futureTask, "T" + i).start();
        }
        int result = 0;
        for (FutureTask<Integer> futureTask : futureTasks) {
            result += futureTask.get();
        }
        System.out.println("最终的结果是：" + result);
    }
}
