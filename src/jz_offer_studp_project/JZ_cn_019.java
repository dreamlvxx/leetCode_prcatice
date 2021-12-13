package jz_offer_studp_project;

public class JZ_cn_019 {
    public boolean validPalindrome(String s) {
        boolean hasDel = false;
        int left = 0;
        int right = s.length() - 1;
        while (left <= right){
            if (!Character.isLetterOrDigit(s.charAt(left))){
                left ++;
            }else if(!Character.isLetterOrDigit(s.charAt(right))){
                right --;
            }else{
                char a = Character.toLowerCase(s.charAt(left));
                char b = Character.toLowerCase(s.charAt(right));
                if(a != b){
                    break;
                }
                left ++;
                right --;
            }
        }
        int left2 = left + 1;
        int right2 = right;
        while (left <= right){
            if (!Character.isLetterOrDigit(s.charAt(left))){
                left ++;
            }else if(!Character.isLetterOrDigit(s.charAt(right))){
                right --;
            }else{
                char a = Character.toLowerCase(s.charAt(left));
                char b = Character.toLowerCase(s.charAt(right));
                if(a != b){

                    return false;
                }
                left ++;
                right --;
            }
        }
        while (left <= right){
            if (!Character.isLetterOrDigit(s.charAt(left))){
                left ++;
            }else if(!Character.isLetterOrDigit(s.charAt(right))){
                right --;
            }else{
                char a = Character.toLowerCase(s.charAt(left));
                char b = Character.toLowerCase(s.charAt(right));
                if(a != b){

                    return false;
                }
                left ++;
                right --;
            }
        }
        return true;
    }
}
