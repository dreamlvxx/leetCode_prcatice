import java.util.ArrayList;
import java.util.List;

public class LeeCode448 {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            result.add(i + 1);
        }
        for (int i = 0; i < nums.length; i++) {
            if (result.contains(nums[i])){
                result.remove(result.indexOf(nums[i]));
            }
        }
        return result;
    }
}
