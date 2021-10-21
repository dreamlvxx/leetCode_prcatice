package jk;

import java.util.Arrays;

public class JK40Code01 {
    public static void main(String[] args) {
        int a = snappack(new int[]{2, 2, 4, 6, 100}, 5, 9);
        System.out.println(a + "");
    }

    /**
     * @param weight 每个要装进去的物品的重量
     * @param n      物品个数
     * @param w      背包承重
     * @return
     */
    public static int snappack(int weight[], int n, int w) {
        boolean[][] states = new boolean[n][w + 1];
        states[0][0] = true;
        states[0][weight[0]] = true;
        for (int i = 1; i < n; ++i) {
            //不放进去的情况
            for (int j = 0; j <= w; j++) {//处理这层信息的时候，上一层的是true，这一层对应的也肯定是true
                if (states[i - 1][j] == true) states[i][j] = true;
            }
            //放进去的情况
            for (int j = 0; j <= w - weight[i]; ++j) {
                if (states[i - 1][j] == true) states[i][j + weight[i]] = true;
            }
        }

        //输出结果
        for (int i = w; i >= 0; --i) {
            if (states[n - 1][i]) return i;
        }
        return 0;
    }


    public static int knapsack4(int[] weight, int[] value, int n, int w) {
        int[] state = new int[w + 1];
        Arrays.fill(state, -1);
        state[0] = 0;
        if (weight[0] < w) {
            state[weight[0]] = value[0];
        }
        for (int i = 1; i < n; i++) {
            for (int j = w - weight[i]; j >= 0; j--) {
                if (state[j] >= 0) {
                    int v = state[j] + value[i];
                    if (v > state[j + weight[i]]) {
                        state[j + weight[i]] = v;
                    }
                }
            }
        }
        for (int i = state.length - 1; i >= 0; i--) {
            if (state[i] >= 0) return state[i];
        }
        return 0;
    }

}
