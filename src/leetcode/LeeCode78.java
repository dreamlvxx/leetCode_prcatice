package leetcode;

import java.util.ArrayList;
import java.util.List;

public class LeeCode78 {
    List<List<Integer>> res = new ArrayList();

    public  List<List<Integer>> subsets(int[] nums) {
        if (nums == null || nums.length == 0) {
            return res;
        }
        ArrayList<Integer> ss = new ArrayList<>();
        res.add(ss);
        addList(nums, 0, new ArrayList<>());
        return res;
    }

    public  void addList(int[] num, int index, ArrayList<Integer> listRes) {
        if (index > num.length - 1 || index < 0) {
            return;
        }
        for (int i = index; i < num.length;) {
            ArrayList<Integer> newList = new ArrayList<>(listRes);
            newList.add(num[i]);
            res.add(newList);
            addList(num, ++i, newList);
        }
    }

}
