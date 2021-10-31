package dp_study_project;

import java.util.Queue;
import java.util.Stack;

public class LeetCode_cn_42 {
    /**
     * 对于每个位置i，可以接的水量等于左边的最大，右边的最大，减去当前的高度
     * @param height
     * @return
     */
    public int trap(int[] height) {
        if(height.length == 0){
            return 0;
        }
        int n = height.length;

        int[] leftMax = new int[n];
        leftMax[0] = height[0];
        for(int i = 1;i < n;i ++){
            leftMax[i] = Math.max(leftMax[i - 1],height[i]);
        }

        int[] rightMax = new int[n];
        rightMax[n - 1] = height[n - 1];
        for(int i = n - 2;i >=0;i --){
            rightMax[i] = Math.max(rightMax[i + 1],height[i]);
        }

        int res = 0;
        for(int i = 0;i < n;i ++){
            res += Math.min(leftMax[i],rightMax[i]) - height[i];
        }
        return res;
    }


    /**
     * 单调栈
     * https://leetcode-cn.com/problems/trapping-rain-water/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by-w-8/
     * 看图比较好理解，
     * @param height
     * @return
     */
    public int trap_stack(int[] height){
        int current = 0;
        int res = 0;
        Stack<Integer> stack = new Stack<>();
        while (current < height.length){
            //第一个条件可以理解为，又左边界的情况下
            //第二个调条件理解为，在有左边界的前提下，找到了被包围的坐标
            while (!stack.isEmpty() && height[current] > height[stack.peek()]){
                int top = stack.pop();
                if (stack.isEmpty())break;

                int topH = height[top];

                int distance = current - stack.peek() - 1;
                int minH = Math.min(height[current],height[stack.peek()]);
                res += distance * (minH - topH);
            }
            stack.push(current);
            current++;
        }
        return res;
    }



}
