package offer;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadCount {


    private static int count = 0;

    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(5);
        service.submit(new MyRunnable());
        service.execute(new MyRunnable());
        service.execute(new MyRunnable());
        service.execute(new MyRunnable());
        service.execute(new MyRunnable());
        getsad();
    }

    public static void getsad(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(count + "");
            }
        }).start();
    }

    static class MyRunnable implements Runnable {
        public void run() {
            while (true) {
                synchronized (MyRunnable.class){
                    if (count >= 1000) {
                        break;
                    }
                    System.out.println(Thread.currentThread().getName() + ":count:" + (count ++));
                }
            }
        }
    }
}
