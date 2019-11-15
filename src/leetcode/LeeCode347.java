package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class LeeCode347 {
    public List<Integer> topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        List<Integer>[] arr = new List[nums.length + 1];

        for (int key : map.keySet()){
            int frequent = map.get(key);
            if (arr[frequent] == null){
                arr[frequent] = new ArrayList<>();
            }
            arr[frequent].add(key);
        }

        List<Integer> res = new ArrayList<>();
        for(int i = arr.length - 1; res.size() < k && i >= 0;i--){
            if (arr[i] != null){
                res.addAll(arr[i]);
            }
        }
        return res;
    }
}
