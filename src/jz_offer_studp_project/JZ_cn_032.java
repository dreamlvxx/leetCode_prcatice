package jz_offer_studp_project;

public class JZ_cn_032 {
    public boolean isAnagram(String s, String t) {
        if(s == null && t == null){
            return true;
        }
        if(s.equals(t)){
            return false;
        }
        if(s.length() != t.length()){
            return false;
        }
        int[] arr = new int[26];

        for(int i = 0;i < s.length();i ++){
            arr[s.charAt(i) - 'a'] ++;
            arr[t.charAt(i) - 'a'] --;
        }
        for(int i = 0;i < 26;i ++){
            if(arr[i] != 0){
                return false;
            }
        }
        return true;
    }
}
