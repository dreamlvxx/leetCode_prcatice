package jz_offer_studp_project;

import java.util.ArrayList;
import java.util.List;

public class JZ_cn_015 {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList();
        int len1 = s.length(),len2 = p.length();
        if(len1 < len2){
            return res;
        }
        int[] scnt = new int[26];
        int[] pcnt = new int[26];

        for(int i = 0;i < len2;i ++){
            pcnt[p.charAt(i) - 'a'] ++;;
        }
        int left = 0,right = 0;
        while(right < len1){
            int x = s.charAt(right) - 'a';
            ++scnt[x];
            while(scnt[x] > pcnt[x]){
                --scnt[s.charAt(left) - 'a'];
                ++left;
            }
            if(right - left + 1 == len2){
                res.add(left);
            }
            ++ right;
        }
        return res;
    }
}
