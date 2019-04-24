import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class LeeCode448 {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        ArrayList<Integer> result = new ArrayList<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;//因为改变值，这里索引肯定是正的
            if (nums[index] > 0){//先判断索引对应的值是否被翻转，翻转过的不需要再翻转了，最后留下的就是没有对应可以被翻转的取值
                nums[index] = -nums[index];
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0){
                result.add(i + 1);
            }
        }
        return result;
    }
}
