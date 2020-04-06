package leetcode;

/**
 *
 */
public class LeeCode581 {

    /**
     * 对于一个递增序列来说，某一个位置的元素一定是从头到此节点最大的节点。
     * 如果不是，说明之前是有逆序存在的。
     * @param nums
     * @return
     */
    public int findUnsortedSubarray1(int[] nums) {
        if(nums == null) return 0;
        if(nums.length == 0 || nums.length == 1) return 0;

        int max = Integer.MIN_VALUE;
        int end = -2;

        for(int i = 0; i < nums.length; i ++){
            max = Math.max(max, nums[i]);
            if(nums[i] < max)
                end = i;
        }

        int min = Integer.MAX_VALUE;
        int begin = -1;

        for(int i = nums.length - 1; i >= 0; i --){
            min = Math.min(min, nums[i]);
            if(nums[i] > min)
                begin = i;
        }

        return end - begin + 1;
    }


    /**
     * 这个是利用插入法的比较，
     * 需要拿每一个位置的元素，和它之前的没一个元素进行比较，然后不断更新最小的边界和最大的边界
     * 这里可以选择交换，也可以选择不交换（不交换可以去掉25,29,32行），但是效率会更低，因为比较的次数变多了
     * @param nums
     * @return
     */
    public static int findUnsortedSubarray(int[] nums) {
        if (nums.length <=1)return 0;
        int has = 0;
        int begin = Integer.MAX_VALUE;
        int end = Integer.MIN_VALUE;
        for (int i = 1; i < nums.length; i++) {
            int target = nums[i];
            int j = i - 1;
            for (; j >= 0; j--) {
                if (nums[j] > target){
                    has = 1;
                    nums[j + 1] = nums[j];
                    end = i;
                    begin =Math.min(j,begin);
                }else{
                    break;
                }
            }
            nums[j + 1] = target;
        }
        System.out.println(begin + "--" + end);
        if (has == 0){
            return 0;
        }
        return end - begin + 1;
    }


}
