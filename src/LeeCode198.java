import java.util.Arrays;

/**
 * 对于求解结果，前后之间联系比较紧的，可以考虑递归
 */
public class LeeCode198 {

    //solution 1 递归   。担心栈会溢出
    public int rob(int[] nums) {
        return robRescu(nums,nums.length - 1);
    }

    public int robRescu(int[] nums,int i){
        if (i < 0){
            return 0;
        }
        return Math.max(robRescu(nums,i - 2) + nums[i],robRescu(nums,i - 1));
    }

    //solution 2
    int[] memo;
    public int rob2(int[] nums) {
        memo = new int[nums.length + 1];
        Arrays.fill(memo, -1);
        return rob(nums, nums.length - 1);
    }

    private int rob(int[] nums, int i) {
        if (i < 0) {
            return 0;
        }
        if (memo[i] >= 0) {
            return memo[i];
        }
        int result = Math.max(rob(nums, i - 2) + nums[i], rob(nums, i - 1));
        memo[i] = result;
        return result;
    }
}
