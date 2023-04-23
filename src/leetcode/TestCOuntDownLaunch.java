package leetcode;

import java.util.Random;
import java.util.concurrent.*;

public class TestCOuntDownLaunch {
    static CyclicBarrier cyclicBarrier = new CyclicBarrier(3, new Runnable() {
        @Override
        public void run() {
            System.out.println("all finish");
        }
    });

    public static void main(String[] args) {
//        ExecutorService se = Executors.newCachedThreadPool();
//
//        se.submit(new Worker(cyclicBarrier));
//        se.submit(new Worker1(cyclicBarrier));
        CyclicBarrier cyclicBarrier = new CyclicBarrier(2, () -> {
            System.out.println("所有参赛选手已准备就绪，比赛开始！");
        });

        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "号选手准备就绪！");
            try {
                Thread.sleep(5000);
                cyclicBarrier.await();//等待所有 parties已经在这个障碍上调用了 await 。（让线程阻塞直到有7个线程阻塞于此）
                System.out.println(Thread.currentThread().getName() + "号选手冲入终点！");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "号选手准备就绪！");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            try {
                cyclicBarrier.await();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } catch (BrokenBarrierException e) {
                throw new RuntimeException(e);
            }
            me1();
        }).start();

    }


    public static void me1() {
        //等待所有 parties已经在这个障碍上调用了 await 。（让线程阻塞直到有7个线程阻塞于此）
        System.out.println(Thread.currentThread().getName() + "号选手冲入终点！");
    }

    public static void me2() {
        System.out.println("m2 exec");
        try {
            Thread.sleep(2000);
            cyclicBarrier.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (BrokenBarrierException e) {
            throw new RuntimeException(e);
        }
        System.out.println("m2 finish");
    }

    public static class Worker implements Runnable {
        public CyclicBarrier lunch;

        public Worker(CyclicBarrier lunch) {
            this.lunch = lunch;
        }

        @Override
        public void run() {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("work finish");
            try {
                lunch.await();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } catch (BrokenBarrierException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static class Worker1 implements Runnable {
        public CyclicBarrier lunch;

        public Worker1(CyclicBarrier lunch) {
            this.lunch = lunch;
        }

        @Override
        public void run() {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("work1 finish");
            try {
                lunch.await();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } catch (BrokenBarrierException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
