package offer;

import java.util.Deque;
import java.util.LinkedList;

/**
 * https://leetcode.cn/problems/XagZNi/
 */
public class Offer037 {
    public int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> stack = new LinkedList();
        for(int ast : asteroids) {
            boolean alive = true;
            while(alive && ast < 0 && !stack.isEmpty() && stack.peek() > 0){
                alive = stack.peek() < -ast;
                if(stack.peek() <= -ast){
                    stack.pop(); //栈顶的爆炸
                }
            }
            if(alive){
                stack.push(ast);
            }
        }
        int size = stack.size();
        int[] ans = new int[size];
        for (int i = size - 1; i >= 0; i--) {
            ans[i] = stack.pop();
        }
        return ans;
    }
}
