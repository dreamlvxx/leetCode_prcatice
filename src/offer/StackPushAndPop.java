package offer;

import java.util.Stack;

/**
 * 题目描述：
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否可能为该栈的弹出顺序。
 * 假设压入栈的所有数字均不相等。例如序列1,2,3,4,5是某栈的压入顺序，
 * 序列4,5,3,2,1是该压栈序列对应的一个弹出序列，
 * 但4,3,5,1,2就不可能是该压栈序列的弹出序列。
 * （注意：这两个序列的长度是相等的）
 */
public class StackPushAndPop {
    /**
     * 分析：
     * 这里可以找出规律是，popA中的第一个元素t，规定了在pushA中的对应t前面的所有元素，在popA中的先后出现顺序是依次逆序出现的。
     * @param pushA
     * @param popA
     * @return
     */
    public boolean IsPopOrder(int [] pushA,int [] popA) {
        //这里先找出来popA第一个元素在pushA中对应的位置在哪。
        int index = 0;
        for(int i = 0;i < pushA.length;i ++){
            if(popA[0] == pushA[i]){
                index = i - 1;
            }
        }
        //只有一个元素，返回true
        if(index == -1){
            return true;
        }
        //没找到，返回false
        if(index == 0){
            return false;
        }
        //找到位置之后判断顺序时候逆序依次出现
        int cu = 0;//这里利用一个最小边界cu，后一个数出现的位置，肯定要在cu的位置之后，否则就是false
        for(int j = index; j >= 0;j --){
            for(int f = 0; f < popA.length; f ++){
                if(pushA[j] == popA[f]){
                    if(f < cu){//出界了，false
                        return false;
                    }
                    cu = f;//更新最小边界
                    break;
                }
            }
        }
        return true;
    }

    //利用一个栈 按照顺序复现
    public boolean IsPopOrder1(int [] pushA,int [] popA) {
        if(pushA.length == 0 || popA.length == 0){
            return false;
        }
        Stack<Integer> stack = new Stack<>();
        int popIndex = 0;
        for(int i = 0;i < pushA.length; i ++){
            if(pushA[i] == popA[popIndex]){
                popIndex ++;
                continue;
            }else{
                stack.push(pushA[i]);
            }
        }
        while(!stack.isEmpty() && popIndex < popA.length){
            if(stack.peek() == popA[popIndex]){
                stack.pop();
            }
            popIndex ++;
        }
        return stack.isEmpty();
    }
}
