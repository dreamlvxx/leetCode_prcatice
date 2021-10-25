package offer;

/**
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个【非递减】【排序】的数组的一个旋转，输出旋转数组的最小元素。
 * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
 * NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 */
public class JZ11 {

    /**
     * 一般针对【数组】的题目，而且一定基础上【有序】，那么可以考虑【二分的变体】
     *
     * @param nums
     * @return
     */
    public int minNumberInRotateArray(int[] nums) {
        //只有一个元素，就是最小的
        if (nums.length == 1) {
            return nums[0];
        }
        //双指针移动寻找
        int l = 0;
        int r = nums.length - 1;

        while (l <= r) {
            int mid = l + (r - l) / 2;
            //情况1，左边的小于右边的，L就是我们要找的
            if (nums[l] < nums[r]) {
                return nums[l];
            }

            if (nums[mid] > nums[mid + 1]) {
                return nums[mid + 1];
            }
            if (nums[mid] < nums[mid - 1]) {
                return nums[mid];
            }

            if (nums[mid] > nums[0]) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return 0;
    }


    public int findMin(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return 0;
        }
        int left = 0;
        int right = nums.length - 1;
        //{3,4,5,1,2}为{1,2,3,4,5}
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[left] < nums[right]) {
                return nums[left];
            }

            if (nums[mid] > nums[mid] + 1) {
                return nums[mid + 1];
            }

            if (nums[mid] < nums[mid - 1]) {
                return nums[mid];
            }

            if (nums[mid] > nums[0]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }

        }
        return 0;
    }

}
