package jz_offer_studp_project;

public class JZ_cn_009 {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if(k <= 1)return 0;
        int n = nums.length;
        int res = 0;
        int base = 1;

        int start = 0,end = 0;

        while(end < n){
            base *= nums[end];
            while(base >= k){
                base /= nums[start];
                start ++;
            }
            res += (end - start + 1);
            end ++;
        }
        return res;
    }
}
