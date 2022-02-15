package dp_study_project;

public class LeetCode_cn_1567 {
    public int getMaxLen(int[] nums) {
        int[] dpPlus = new int[nums.length];
        int[] dpMinus = new int[nums.length];

        if(nums[0] > 0){
            dpPlus[0] = 1;
            dpMinus[0] = 0;
        }else if(nums[0] < 0){
            dpPlus[0] = 0;
            dpMinus[0] = 1;
        }

        int max = dpPlus[0];
        for(int i = 1;i < nums.length;i ++){
            if(nums[i] > 0){
                dpPlus[i] = dpPlus[i - 1] + 1;
                dpMinus[i] = dpMinus[i - 1] > 0 ? dpMinus[i - 1] + 1 : 0;
            }else if(nums[i] < 0){
                dpPlus[i] = dpMinus[i - 1] > 0 ? dpMinus[i - 1] + 1 : 0;
                dpMinus[i] = dpPlus[i - 1] + 1;
            }else{
                dpPlus[i] = 0;
                dpMinus[i] = 0;
            }
            max = Math.max(max,dpPlus[i]);
        }
        return max;
    }
}
