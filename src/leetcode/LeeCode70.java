package leetcode;

import java.util.HashMap;

/**
 * ou are climbing a stair case. It takes n steps to reach to the top.
 * <p>
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 */
public class LeeCode70 {
    //利用递归
    //避免重复计算，可以对值用hash表进行存储，有的话直接利用
    HashMap<Integer, Integer> map = new HashMap<>();
    public int method(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        if (map.containsKey(n)) {
            return map.get(n);
        }
        int result = method(n - 1) + method(n - 2);
        map.put(n, result);
        return result;
    }

    //利用动态规划
    public int climbStairs(int n) {
        // base cases
        if (n <= 0) return 0;
        if (n == 1) return 1;
        if (n == 2) return 2;

        int one_step_before = 2;
        int two_steps_before = 1;
        int all_ways = 0;

        for (int i = 2; i < n; i++) {
            all_ways = one_step_before + two_steps_before; //这个和不必多说
            two_steps_before = one_step_before;//画个简单的图可以看出来，下一个楼梯回退两步的步数就是当时走一步的步数
            one_step_before = all_ways;//画图，下一个楼梯回退一步的步数就是当时的总步数
        }
        return all_ways;
    }
}
