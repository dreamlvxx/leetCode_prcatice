package leetcode;

import java.util.ArrayList;

public class YueSeFuCircle {
    public static void main(String[] args) {
        circle(30,9);
    }
    public static String circle(int total, int k){
        ArrayList<String> res = new ArrayList<>();

        for (int i = 0; i < total; i++) {
            res.add((i + 1) + "");
        }

        int index = -1;
        while (res.size() > 1){
            for (int i = 0;i < k; ++ i){
                if (index >= res.size() - 1){
                    index = 0;
                }else{
                    index ++;
                }
            }
            System.out.println(res.remove(index));
        }
        return res.get(0);
    }


}
