package dp_study_project;

public class LeetCode_cn_152 {
    /**
     * 因为这里涉及负负得正，所以不再能简单的用前面的乘机跟现在的做对比，
     * 这个时候应该保存俩值，一个最大一个最小，最小可能为负数，当目前的值是正的时候，可能会更大。
     * @param nums
     * @return
     */
    public int maxProduct(int[] nums) {
        int[] dpMax = new int[nums.length];
        int[] dpMin = new int[nums.length];

        dpMax[0] = dpMin[0] = nums[0];

        for(int i = 1;i < nums.length;i ++){
            if(nums[i] > 0){
                dpMax[i] = Math.max(dpMax[i - 1] * nums[i],nums[i]);
                dpMin[i] = Math.min(dpMin[i - 1] * nums[i],nums[i]);
            }else{
                dpMax[i] = Math.max(dpMin[i - 1] * nums[i],nums[i]);
                dpMin[i] = Math.min(dpMax[i - 1] * nums[i],nums[i]);
            }
        }

        int res = Integer.MIN_VALUE;
        for(int i = 0;i < nums.length;i ++){
            res = Math.max(res,dpMax[i]);
        }
        return res;
    }
}
