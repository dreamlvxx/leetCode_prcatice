package jz_offer_studp_project;

public class JZ_cn_005 {
    public int maxProduct1(String[] words){
        int max = 0;
        for(int i = 0;i < words.length;i ++){
            String word1 = words[i];
            for (int j = i + 1; j < words.length; j++) {
                String word2 = words[j];
                if(hasSameWord(word1,word2)){
                    max = Math.max(max,word1.length() * word2.length());
                }
            }
        }
        return max;
    }

    //利用每位character判断
    public boolean hasSameWord(String s1,String s2){
        int[] arr = new int[26];
        for(char c : s1.toCharArray()){
            arr[c - 'a'] = 1;
        }
        for(char c : s2.toCharArray()){
            if(arr[c - 'a'] == 1){
                return true;
            }
        }
        return false;
    }

    public boolean hasSameWord1(String s1,String s2){
        int bitMask1 = 0,bitMask2 = 0;
        for(char c : s1.toCharArray()){
            bitMask1 |= 1 << (c - 'a');
        }
        for(char c : s2.toCharArray()){
            bitMask2 |= 1 << (c - 'a');
        }
        if((bitMask1 & bitMask2) != 0){
            return true;
        }
        return false;
    }

    public static boolean can(int num){
        System.out.println("inter");
        for (int i = 0; i < 3; i++) {
            System.out.println("i = " + i);
            if(i == 1 && can(i)){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        can(0);
    }



}
