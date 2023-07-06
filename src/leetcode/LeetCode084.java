package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * https://leetcode.cn/problems/largest-rectangle-in-histogram/
 */
public class LeetCode084 {
    public int largestRectangleArea(int[] heights) {
        Deque<Integer> stack = new ArrayDeque();
        int length = heights.length;
        int[] left = new int[length];
        int[] right = new int[length];
        for(int i = 0;i < length;i ++){
            while(!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }
            left[i] = stack.isEmpty()? -1 : stack.peek();  //最左端的哨兵位置为-1
            stack.push(i);
        }
        stack.clear();
        for(int i = length - 1;i >= 0;i --) {
            while(!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }
            right[i] = stack.isEmpty()? length : stack.peek(); //最右端的哨兵位置为length
            stack.push(i);
        }
        int ans = 0;
        for(int i = 0;i < length;i ++) {
            ans = Math.max((right[i] - left[i] - 1) * heights[i],ans);
        }
        return ans;
    }

}
