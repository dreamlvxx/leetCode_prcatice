package leetcode;

import java.util.Stack;

public class LeeCode739 extends LeeCode581{

    public static void main(String[] args) {
        int[] arr = {73, 74, 75, 71, 69, 72, 76, 73};
        int[] res = dailyTemperatures(arr);
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }
    }

    //思路： 一次遍历过程中，寻找条件，需要回滚的时候，借助栈这个结构，或许是个不错的选择
    public static int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int[] ret = new int[temperatures.length];
        for(int i = 0; i < temperatures.length; i++) {
            while(!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int idx = stack.pop();
                ret[idx] = i - idx;
            }
            stack.push(i);
        }
        return ret;
    }
}
