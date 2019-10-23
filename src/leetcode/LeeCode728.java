package leetcode;

import java.util.ArrayList;
import java.util.List;

public class LeeCode728 {
    public static List<Integer> selfDividingNumbers(int left, int right) {
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = left; i <=right; i++) {
            if (filterNum(i) != 0){
                res.add(i);
            }
        }
        return res;
    }

    public static Integer filterNum(int num){
        boolean isCan = true;
        String numStr = String.valueOf(num);
        if (numStr.contains("0")){
            return 0;
        }
        for (int i = 0; i < numStr.length(); i++) {
            int c = Integer.parseInt(String.valueOf(numStr.charAt(i)));
            if (num % c != 0){
                isCan = false;
                break;
            }
        }
        return isCan?num : 0;
    }
}
