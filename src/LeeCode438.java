import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * counter是一个控制器
 */
public class LeeCode438 {
    public List<Integer> findAnagrams(String s, String p) {


        return null;
    }

    //LeetCode198  Find All Anagrams in a String
    public List<Integer> findAnagrams1(String s, String t) {
        List<Integer> result = new LinkedList<>();
        if (t.length() > s.length()) return result;
        Map<Character, Integer> map = new HashMap<>();
        for (char c : t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int counter = map.size();
        int begin = 0, end = 0;

        while (end < s.length()) {
            //这段代码找到可以包含所有target字母的区间
            //-------------------------------------
            char c = s.charAt(end);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) - 1);
                if (map.get(c) == 0) counter--;
            }
            end++;
            //---------------------------------------
            while (counter == 0) {//当counter为0的时候，being到end子串已经包含了目标所有的字母
                char tempc = s.charAt(begin);
                if (map.containsKey(tempc)) {
                    map.put(tempc, map.get(tempc) + 1);
                    if (map.get(tempc) > 0) {
                        counter++;
                    }
                }
                if (end - begin == t.length()) {
                    result.add(begin);
                }
                begin++;
            }
        }
        return result;
    }

    //76 Minimum Window Substring

    /**
     * 想比较于直接brute force解决来说，
     * 其中利用了map，当可以包含所有的字母的时候，我们才进行寻找匹配，因此会减少很多对于子串的处理
     * counter还是控制器的作用  这个自己来顶规则  可以控制即可。
     * @param s
     * @param t
     * @return
     */
    public String minWindow(String s, String t) {
        if (t.length() > s.length()) return "";
        Map<Character, Integer> map = new HashMap<>();//多一个这个，当他其中的所有元素
        for (char c : t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int counter = map.size();

        int begin = 0, end = 0;
        int head = 0;
        int len = Integer.MAX_VALUE;

        while (end < s.length()) {
            //下面这段代码就是先去把要找的子串包含的字母都找出来，确定一个区间。
            //--------------------------------
            char c = s.charAt(end);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) - 1);
                if (map.get(c) == 0) counter--;
            }
            end++;
            //----------------------------------

            //这个地方就是当我们找到了满足条件的那个区间的时候进行处理
            while (counter == 0) {//当counter为0的时候，being到end子串已经包含了目标所有的字母
                char tempc = s.charAt(begin);
                if (map.containsKey(tempc)) {
                    map.put(tempc, map.get(tempc) + 1);
                    if (map.get(tempc) > 0) {//这个地方就是我们要做的判断条件，当其中有一个大于0了，那么说明此时的子串中已经不能包含所有target串中的字母
                        counter++;
                    }
                }
                if (end - begin < len) {
                    len = end - begin;
                    head = begin;
                }
                begin++;
            }

        }
        if (len == Integer.MAX_VALUE) return "";
        return s.substring(head, head + len);
    }

    //003 最长不重复子串
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int begin = 0, end = 0, counter = 0, d = 0;

        while (end < s.length()) {
            // > 0 means repeating character
            //if(map[s.charAt(end++)]-- > 0) counter++;
            char c = s.charAt(end);
            map.put(c, map.getOrDefault(c, 0) + 1);
            if (map.get(c) > 1) counter++;//counter相当于一个控制器
            end++;

            while (counter > 0) {
                //if (map[s.charAt(begin++)]-- > 1) counter--;
                char charTemp = s.charAt(begin);
                if (map.get(charTemp) > 1) counter--;
                map.put(charTemp, map.get(charTemp) - 1);//遍历过的已经不再begin的范围内了，清除
                begin++;
            }

            d = Math.max(d, end - begin);
        }
        return d;
    }

    //template
    public List<Integer> slidingWindowTemplateByHarryChaoyangHe(String s, String t) {
        //init a collection or int value to save the result according the question.
        List<Integer> result = new LinkedList<>();
        if (t.length() > s.length()) return result;
        //create a hashmap to save the Characters of the target substring.
        //(K, V) = (Character, Frequence of the Characters)
        Map<Character, Integer> map = new HashMap<>();
        for (char c : t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        //maintain a counter to check whether match the target string.
        int counter = map.size();//must be the map size, NOT the string size because the char may be duplicate.
        //Two Pointers: begin - left pointer of the window; end - right pointer of the window
        int begin = 0, end = 0;
        //the length of the substring which match the target string.
        int len = Integer.MAX_VALUE;
        //loop at the begining of the source string
        while (end < s.length()) {
            char c = s.charAt(end);//get a character
            if (map.containsKey(c)) {
                map.put(c, map.get(c) - 1);// plus or minus one
                if (map.get(c) == 0) counter--;//modify the counter according the requirement(different condition).
            }
            end++;
            //increase begin pointer to make it invalid/valid again
            while (counter == 0 /* counter condition. different question may have different condition */) {
                char tempc = s.charAt(begin);//***be careful here: choose the char at begin pointer, NOT the end pointer
                if (map.containsKey(tempc)) {
                    map.put(tempc, map.get(tempc) + 1);//plus or minus one
                    if (map.get(tempc) > 0)
                        counter++;//modify the counter according the requirement(different condition).
                }
                /* save / update(min/max) the result if find a target*/
                // result collections or result int value

                begin++;
            }
        }
        return result;
    }
}
