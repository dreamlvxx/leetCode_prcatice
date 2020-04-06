package leetcode;

import java.util.HashMap;

public class LeeCode003 {


    /**
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        if (null == s || s.length() == 0) {
            return 0;
        }
        int max = 0;
        int j = 0; //不重复的最左边界
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                //这里用Math.max保证j不会回退，比如"abbacvb"，当b重复，那么j会更新到2，当a重复，可能造成回退到0，所以要加max
                j = Math.max(j, map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i), i);
            max = Math.max(max, i - j + 1);
        }
        return max;
    }
}
