package other_demo;

public class MutiThreadPrint {

    public static void main(String[] args) {
        print();
    }
    static int index = 0;

    public static void print(){
        Object obj = new Object();
        String[] arr = new String[4];
        arr[0] = "A";
        arr[1] = "B";
        arr[2] = "C";
        arr[3] = "D";

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (obj){
                    while (index < arr.length){
                        if(index % 2 == 0){
                            System.out.println(Thread.currentThread().getName() + arr[index]);
                            index ++;
                            obj.notify();
                            try {
                                obj.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (obj){
                    while (index < arr.length){
                        if(index % 2 != 0){
                            System.out.println(Thread.currentThread().getName() + arr[index]);
                            index ++;
                            obj.notify();
                            try {
                                obj.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }
        });

        t1.start();
        t2.start();
    }
}
