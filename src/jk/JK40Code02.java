package jk;

public class JK40Code02 {
    /**
     * @param weight 每个要装进去的物品的重量
     * @param value 每个要装进去的物品的价值
     * @param n 物品个数
     * @param w 背包重量
     * @return
     */
    public int snapsack02(int weight[],int value[],int n ,int w){

        int[][] state = new int[n][w + 1];
        //初始化表格
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < w + 1; j++) {
                state[i][j] = -1;
            }
        }
        //第一行的物品放与不放的处理
        state[0][0] = 0;
        state[0][weight[0]] = value[0];
        //动态规划
        for (int i = 1; i < n; i++) {
            //当前选择的物品不放进去的时候
            for (int j = 0; j < w + 1; j++) {
                if (state[i - 1][j] >= 0) state[i][j] = state[i - 1][j];
            }
            //当前物品放进去
            for (int j = 0; j < w - weight[i]; j++) {
                if (state[i - 1][j] >= 0){
                    int v = state[i - 1][j] + value[i];
                    if (v > state[i][j + weight[i]]){
                        state[i][j + weight[i]] = v;
                    }
                }
            }
        }
        //找到最后一列最大的值
        int maxvalue = -1;
        for (int i = 0; i < w + 1; i++) {
            if (state[n - 1][i] > maxvalue) maxvalue = state[n][i];
        }
        return maxvalue;
    }
}
