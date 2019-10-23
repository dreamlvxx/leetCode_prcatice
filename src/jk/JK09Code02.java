package jk;

/**
 * 循环队列实现
 * 解决了线性队列的数据搬移的问题
 * 注意队满和队空的判断
 */
public class JK09Code02 {
    private int head = 0;
    private int tail = 0;
    private String arr[];
    private int length;

    public JK09Code02(int length) {
        arr = new String[length];
        this.length = length;
    }

    /**
     * 入队
     * @param s
     * @return
     */
    private boolean enqueue(String s){
        if ((tail + 1) % length == head)return false;//满了
        arr[tail] = s;
        tail = (tail + 1) % length;
        return true;
    }

    /**
     * 出队
     * @return
     */
    private String dequeue(){
        if (head == tail) return null;//空了
        String res = arr[head];
        head = (head + 1) % length;
        return res;
    }


}
