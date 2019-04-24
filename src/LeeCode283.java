
public class LeeCode283 {
    //计数0
    public void moveZeroesMine(int[] nums) {
        int zeroNumber = 0;
        for (int i = 0; i < nums.length; i++) {
            int temp = nums[i];
            if (nums[i] != 0) {
                int j = i - 1;
                for (; j >= i - zeroNumber; j--) {
                    nums[j + 1] = nums[j];
                }
                nums[j + 1] = temp;
            } else {
                zeroNumber++;
            }
        }
    }

    //计数非0
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) return;

        int insertPos = 0;
        for (int num: nums) {
            if (num != 0) nums[insertPos++] = num;
        }

        while (insertPos < nums.length) {
            nums[insertPos++] = 0;
        }
    }
}
