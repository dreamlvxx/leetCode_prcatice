package jz_offer_studp_project;

import java.util.HashMap;
import java.util.Map;

public class JZ_cn_034 {
    public boolean isAlienSorted(String[] words, String order) {
        char[] arr = order.toCharArray();
        Map<Character,Integer> map = new HashMap();
        for(int i = 0;i < order.length();i ++){
            map.put(order.charAt(i),i);
        }
        int n = words.length;
        for(int i = 0;i < n - 1;i ++){
            String w1 = words[i];
            int len1 = w1.length();
            String w2 = words[i + 1];
            int len2 = w2.length();
            for(int j = 0;j < Math.max(len1,len2);j ++){
                int index1 = j >= len1? -1 : map.get(w1.charAt(j));
                int index2 = j >= len2? -1 : map.get(w2.charAt(j));
                if(index1 > index2)return false;
                if(index1 < index2)break;
            }
        }
        return true;
    }
}
