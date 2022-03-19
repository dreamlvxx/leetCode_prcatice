package jz_offer_studp_project;

import java.util.HashMap;
import java.util.Map;

public class JZ_cn_016 {
    public int lengthOfLongestSubstring(String s){
        int max = 0;
        int start = 0;
        Map<Character,Integer> map = new HashMap<>();
        for(int end = 0;end < s.length();end ++){
            if(map.containsKey(s.charAt(end))){
                start = Math.max(start,map.get(s.charAt(end)) + 1);
            }
            max = Math.max(max,end - start + 1);
            map.put(s.charAt(end),end);
        }
        return max;
    }
}
