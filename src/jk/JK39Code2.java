package jk;

/**
 *  0-1 背包问题
 *  枚举每一种情况
 */
public class JK39Code2 {
    public int maxW = Integer.MIN_VALUE; //表示最后的结果
    /**
     * @param i 考察到那个物品了
     * @param cw 已经装进去的物品的重量总和
     * @param items 每个物品的重量
     * @param n 所有物品的个数
     * @param w 背包承受重量
     */
    public void f(int i ,int cw ,int[] items ,int n ,int w){
        if (cw == w || i == n){ //装满了 或者 考察完所有的物品了  (这里应用了剪枝)
            if (cw > maxW)maxW = cw;//结束的时候判断cw总和是否大于maxW  给maxW赋值
            return;
        }
        //这个通过举例实现流程，会发现会先递归到最后一个物品
        //然后通过递归到倒数第二个，再累加，过程中的递归又会累加所有情况
        f(i + 1,cw,items,n,w);
        if (cw + items[i] <= w){ //不超过背包承受重量的时候，才可以装
            f(i + 1,cw + items[i],items,n,w);
        }
    }
}
