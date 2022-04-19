package other_demo;

import java.util.concurrent.*;

public class FutureTaskDemo {
    public static void main(String[] args) {
        try {
            testFuture();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void testFuture() throws ExecutionException, InterruptedException {
        ExecutorService service = Executors.newCachedThreadPool();
        FutureTask<String>  task = new FutureTask<>(new Callable<String>() {
            @Override
            public String call() throws Exception {
                Thread.sleep(2000);
                return "this is result";
            }
        });

        service.submit(task);

        System.out.println(task.get());

    }
}
