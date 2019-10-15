/**
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
 * NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 */
public class Offer06 {
    /**
     * 关键在于是非递减的
     * 旋转之后的数组实际上可以划分成两个有序的子数组：前面子数组的大小都大于后面子数组中的元素.
     * 通过mid的变换，
     * 最终第一个指针将指向前面数组的最后一个元素，第二个指针指向后面数组中的第一个元素。
     * 也就是说他们将指向两个相邻的元素，而第二个指针指向的刚好是最小的元素，这就是循环的结束条件。
     * @param nums
     * @return
     */
    public int minNumberInRotateArray(int[] nums) {
        int size = nums.length;
        if (size == 0){
            return 0;
        }
        int left = 0,right = size - 1;
        int mid = 0;
        while (nums[left] > nums[right]){//如果旋转了，那么第一个肯定大于最后一个
            if (right - left == 1){//终结条件，两个指针相邻，第二个就是最小的。
                mid = right;
                break;
            }
            mid = left + (right - left)/2;
            //这个是处理特殊情况，遇到10111这种的时候，left mid right指向的值都相同。那么就寻找最小的返回即可。
            if(nums[left] == nums[right] && nums[left] == nums[mid]){
                return minNum(nums,left,right);
            }

            //这个通过判断mid与left right值对比，移动指针。
            if (nums[mid] > nums[left]){
                right = mid;
            }else{
                left = mid;
            }

        }
        return nums[mid];
    }
    
    private int minNum(int[] nums,int l,int r){
        int res = nums[0];
        for (int i = l + 1; i < r; i++) {
            if (nums[i] < res){
                res = nums[i];
            }
        }
        return res;
    }
}
