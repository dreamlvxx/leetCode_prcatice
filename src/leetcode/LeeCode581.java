package leetcode;

/**
 *
 */
public class LeeCode581 {
    //这个是利用插入法，查看哪个移动了 哪个没有移动
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

    // O(n)的解法
    public int findUnsortedSubarray1(int[] nums) {
        int i = 0, j = -1;
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;

        for (int l = 0, r = nums.length - 1; r >= 0; l++, r--) {
            max = Math.max(max, nums[l]);
            if (nums[l] != max) j = l;

            min = Math.min(min, nums[r]);
            if (nums[r] != min) i = r;
        }

        return (j - i + 1);
    }
}
