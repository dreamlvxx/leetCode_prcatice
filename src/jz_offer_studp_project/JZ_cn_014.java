package jz_offer_studp_project;

public class JZ_cn_014 {
    public boolean checkInclusion(String s1, String s2) {
        int len1 = s1.length(),len2 = s2.length();
        if(len1 > len2){
            return false;
        }
        int[] cnt = new int[26];
        for(int i = 0;i < len1;i ++){
            --cnt[s1.charAt(i) - 'a'];
        }
        int left = 0,right = 0;
        while(right < len2){
            int x = s2.charAt(right) - 'a';
            ++cnt[x];
            while(cnt[x] > 0){
                --cnt[s2.charAt(left) - 'a'];
                ++left;
            }
            if(right - left + 1 == len1){
                return true;
            }
            right ++;
        }
        return false;
    }
}
