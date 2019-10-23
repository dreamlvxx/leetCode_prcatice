package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

/**
 * 摩尔投票算法 https://www.zhihu.com/question/49973163/answer/235921864
 */
public class LeeCode169 {
    //暴力解决
    public int majorityElementMine(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])){
                map.put(nums[i],1);
            }else{
                int a = map.get(nums[i]) + 1;
                map.put(nums[i],a);
            }
        }
        System.out.println(map);
        int result = 0;
        int maxValue = 0;
        Set<Integer> set = map.keySet();
        for (Integer key : set) {
            int value = map.get(key);
            if (maxValue <= value) {
                result = key;
                maxValue = value;
            }
        }
        return result;
    }

    //摩尔算法实现（抵消）
    public int majorityElement(int[] arr){
        ArrayList<Integer> result = new ArrayList<>();
        for (int value : arr) {
            if (result.isEmpty()) {
                result.add(value);
            } else {
                if (result.get(result.size() - 1) != value) {
                    result.remove(result.size() - 1);
                } else {
                    result.add(value);
                }
            }
        }
        return result.get(0);
    }
}
