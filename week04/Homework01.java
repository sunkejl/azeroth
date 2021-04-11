import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.function.Supplier;


//        异步计算结果为：24157817
//        使用时间：50 ms
//
//        Process finished with exit code 0

public class Homework01 {

    public static void main(String[] args) {

        long start=System.currentTimeMillis();

        // 在这里创建一个线程或线程池，
        // 异步执行 下面方法

        Supplier<Integer> supplier = () -> {
            System.out.println(Thread.currentThread().getName());
            return sum();
        };
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(supplier);
        Integer result = null;
        try {
            //blocking
            result = future.get();
            System.out.println(result);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }




//        int result = sum(); //这是得到的返回值

        // 确保  拿到result 并输出
        System.out.println("异步计算结果为："+result);

        System.out.println("使用时间："+ (System.currentTimeMillis()-start) + " ms");

        // 然后退出main线程
    }

    private static int sum() {
        return fibo(36);
    }

    private static int fibo(int a) {
        if ( a < 2) {
            return 1;
        }
        return fibo(a-1) + fibo(a-2);
    }
}