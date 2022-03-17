package jz_offer_studp_project;

import java.util.HashMap;
import java.util.Map;

public class JZ_cn_011 {

    public int findMaxLength1(int[] nums) {
        int maxLength = 0;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int counter = 0;
        map.put(counter, -1);
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int num = nums[i];
            if (num == 1) {
                counter++;
            } else {
                counter--;
            }
            if (map.containsKey(counter)) {
                int prevIndex = map.get(counter);
                maxLength = Math.max(maxLength, i - prevIndex);
            } else {
                map.put(counter, i);
            }
        }
        return maxLength;
    }



    //超时
    public int findMaxLength(int[] nums) {
        int len = nums.length;
        int[] pre = new int[len + 1];;
        for(int i = 1;i <= len;i ++){
            pre[i] = pre[i - 1] + nums[i - 1];
        }

        int max = 0;
        for(int i = 0;i < len;i ++){
            for(int j = i;j < len;j ++){
                if(pre[j + 1] - pre[i] == (j + 1 - i) / 2  && (j + 1 - i) % 2 == 0){
                    max = Math.max(max,j + 1 - i);
                }
            }
        }
        return max;
    }
}
