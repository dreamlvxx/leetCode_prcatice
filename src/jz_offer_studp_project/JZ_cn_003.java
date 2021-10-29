package jz_offer_studp_project;

public class JZ_cn_003 {
    /**
     * 找规律
     * 如果是一个偶数 ，那么可以最低位肯定是0，所以右移一位（相当于除以2），不会改变其中1的数量，所以有dp[i] = dp[i / 2]
     * 如果是一个奇数，那么他的最后一位肯定是1，那么他相对于比他小1的偶数，其实就多一个最低位的1，所有有dp[i] = dp[i - 1] + 1
     * @param n
     * @return
     */
    public int[] countBits(int n) {
        int[] dp = new int[n + 1];
        for(int i = 1;i <= n;i ++){
            if(i % 2 == 0){
                dp[i] = dp[i / 2];
            }else{
                dp[i] = dp[i - 1] + 1;
            }

        }
        return dp;
    }
}
