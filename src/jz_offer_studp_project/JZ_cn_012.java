package jz_offer_studp_project;

public class JZ_cn_012 {
    public int pivotIndex(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for(int i = 0;i < n;i ++){
            sum += nums[i];
        }
        int leftSum = 0;
        for(int i = 0;i < n;i ++){
            if(leftSum == sum - leftSum - nums[i]){
                return i;
            }
            leftSum += nums[i];
        }
        return -1;
    }
}
