package jz_offer_studp_project;

public class JZ_cn_004 {
    /**
     * 这个还是需要用到二进制。针对每一位来说，将所有数字的对应位相加，所得的结果，就是3个相同的数字的和 加上 一个另类数字的和
     * 一个数字 & 1可以得到最低位的结果
     * @return
     */
    public int singleNumber(int nums[]){
        int res = 0;
        for(int i = 0;i < 32;i ++){
            int temp = 0;
            for(int num : nums){
                temp += (num >> i) & 1;
            }
            if(temp % 3 != 0){ //不是0，就是1
                res |= 1 << i;
            }
        }
        return res;
    }
}
