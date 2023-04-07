package scroll_window;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class LeetCode017 {
    Map<Character, Integer> refer = new HashMap();
    Map<Character, Integer> windowMap = new HashMap();

    public String minWindow(String s, String t) {

        int len = s.length();

        int l = 0,r = -1;

        int minLen = Integer.MAX_VALUE;
        int resL = -1,resR = -1;

        for(int i = 0;i < t.length();i ++) {
            refer.put(t.charAt(i),refer.getOrDefault(t.charAt(i),0) + 1);
        }


        while(r < len) {
            ++r;
            if(r < len && refer.containsKey(s.charAt(r))){
                windowMap.put(s.charAt(r),windowMap.getOrDefault(s.charAt(r),0) + 1);
            }
            while(match() && l <= r) {
                if(r - l + 1 < minLen) {
                    minLen = r - l + 1;
                    resL = l;
                    resR = l + minLen;
                }

                if(refer.containsKey(s.charAt(l))){
                    windowMap.put(s.charAt(l),windowMap.getOrDefault(s.charAt(l),0) - 1);
                }
                ++l;
            }
        }
        return resL == -1 ? "" : s.substring(resL,resR);
    }

    public boolean match(){
        Iterator ite = refer.entrySet().iterator();
        while(ite.hasNext()) {
            Map.Entry entry = (Map.Entry)ite.next();
            Character key = (Character)entry.getKey();
            Integer value = (Integer)entry.getValue();
            if(windowMap.getOrDefault(key,0) < value) {
                return false;
            }
        }
        return true;
    }

}
