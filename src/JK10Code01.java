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

    //动态规划
    public int climbStairs(int n) {
        // base cases
        if(n <= 0) return 0;
        if(n == 1) return 1;
        if(n == 2) return 2;

        int one_step_before = 2;
        int two_steps_before = 1;
        int all_ways = 0;

        for(int i=2; i<n; i++){
            all_ways = one_step_before + two_steps_before;
            two_steps_before = one_step_before;
            one_step_before = all_ways;
        }
        return all_ways;
    }
}


