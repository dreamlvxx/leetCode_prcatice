package jz_offer_studp_project;

public class JZ_cn_019 {
    public static void main(String[] args) {
        boolean res = validPalindrome("deeee");
        System.out.println("" + res);
    }
    public static boolean validPalindrome(String s) {
        for(int left = 0,right = s.length() - 1;left <= right;left ++,right --){
            if(s.charAt(left) != s.charAt(right)){
                return isPar(s,left,right - 1) || isPar(s,left + 1,right);
            }
        }
        return true;
    }

    public static boolean isPar(String s,int left,int right){
        System.out.println(left + " --" + right);
        while (left <= right){
            if (s.charAt(left) != s.charAt(right)){
                return false;
            }
            left ++;
            right--;
        }
        return true;
    }
}
