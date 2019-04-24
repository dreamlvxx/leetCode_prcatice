/**
 * 数组实现队列
 */
public class JK09Code1 {
    public class ArrayQueue{

        private String[] arr;
        private int capacity;
        int head = 0;
        int tail = 0;

        public ArrayQueue(int n) {
            arr = new String[n];
            capacity = n;
        }

        //出队
        public String dequeue(){
            if (head == tail)return null;
            String res = arr[head];
            ++head;
            return res;
        }

        //入队 优化 在入队的时候判断是否满了 满了进行数据迁移
        public boolean enQueue(String s){
            if (tail == capacity){
                if (head == 0)return false;//head是0的时候说明整个队列已经满了
                for (int i = head; i < tail; i++) {
                    arr[i - head] = arr[head];
                }
                tail -= head;
                head = 0;
            }

            arr[tail] = s;
            ++tail;
            return true;
        }
    }
}
