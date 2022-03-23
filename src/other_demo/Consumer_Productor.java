package other_demo;

public class Consumer_Productor {
    static class Resourse {
        int num = 10;
        public synchronized void add(){
            if(num < 10){
                num ++;
                System.out.println("after add num = " + num);
                notifyAll();
            }else{
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        public synchronized void remove(){
            if(num > 0){
                num --;
                System.out.println("after remove num = " + num);
                notifyAll();
            }else{
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class ConsumerThread extends Thread{
        Resourse resourse;

        public ConsumerThread(Resourse resourse) {
            this.resourse = resourse;
        }

        @Override
        public void run() {
            super.run();
            while (true){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                resourse.remove();
            }
        }
    }


    static class ProductThread extends Thread {
        Resourse resourse;

        ProductThread(Resourse resourse){
            this.resourse = resourse;
        }

        @Override
        public void run() {
            super.run();
            while (true){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                resourse.add();
            }
        }
    }


    public static void main(String[] args) {
        Resourse resourse = new Resourse();

        ProductThread pro1 = new ProductThread(resourse);

        ConsumerThread con1 = new ConsumerThread(resourse);
        ConsumerThread con2 = new ConsumerThread(resourse);
        ConsumerThread con3 = new ConsumerThread(resourse);


        pro1.start();
        con1.start();
        con2.start();
        con3.start();
    }
}
