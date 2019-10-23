package jk;

public class JK40Code01 {
    /**
     * @param weight 每个要装进去的物品的重量
     * @param n 物品个数
     * @param w 背包承重
     * @return
     */
    public int snappack(int weight[],int n,int w){
        boolean [][] states = new boolean[n][w +1];
        states[0][0] = true;
        states[0][weight[0]] = true;
        for (int i = 1; i < n; ++i) {//不放进去的时候
            for (int j = 0; j <= w; j++) {//处理这层信息的时候，上一层的是true，这一层对应的也肯定是true
                if (states[i - 1][j] == true) states[i][j] = true;
            }

            for (int j = 0; j <= w - weight[i]; ++ j) {
                if (states[i - 1][j] == true) states[i][j + weight[i]] = true;
            }
        }

        //输出结果
        for (int i = w; i >= 0 ; --i) {
            if (states[n - 1][i]) return i;
        }
        return 0;
    }

}
