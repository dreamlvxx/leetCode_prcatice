package leetcode;

public class LeeCode942 {
    public int[] diStringMatch(String S) {
        char[] arr = S.toCharArray();
        int[] res = new int[S.length() + 1];
        int end = S.length();
        int start = 0;
        for (int i = 0; i < arr.length ; i++) {
            if ('I' == arr[i]){
                res[i] = start;
                if (i == arr.length - 1){
                    res[i + 1] = start + 1;
                }
                start ++ ;
            }else{
                res[i] = (char) end;
                if (i == arr.length - 1){
                    res[i + 1] = (char) (end - 1);
                }
                end -- ;
            }
        }
        return res;
    }
}
