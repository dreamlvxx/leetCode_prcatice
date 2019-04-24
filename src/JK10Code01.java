import java.util.HashMap;

/**
 * 题目：有n个台阶，每次可以跨一个台阶或者两个台阶，请问n个台阶有多少种走法
 */
public class JK10Code01 {
    //避免重复计算，可以对值用hash表进行存储，有的话直接利用
    HashMap<Integer, Integer> map = new HashMap<>();
    public int method(int n){
        if (n == 1)return 1;
        if (n == 2)return 2;
        if (map.containsKey(n)){
            return map.get(n);
        }
        int result = method(n - 1) + method(n - 2);
        map.put(n,result);
        return result;
    }
}


