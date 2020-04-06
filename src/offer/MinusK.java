package offer;

import java.util.ArrayList;
import java.util.Collections;

public class MinusK {
    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        ArrayList<Integer> res = new ArrayList();
        if (k > input.length || k == 0) {
            return res;
        } else {
            for (int i = 0; i < k; i++) {
                res.add(input[i]);
            }
            Collections.sort(res);
        }

        for (int j = k; j < input.length; j++) {
            if (input[j] >= res.get(k - 1)) {
                continue;
            } else {
                res.remove(k - 1);
                res.add(input[j]);
                Collections.sort(res);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        FirstNotRepeatingChar("google");
    }

    public static int FirstNotRepeatingChar(String str) {
        char[] arr = str.toCharArray();
        ArrayList<Character> list = new ArrayList();
        for (int i = 0; i < arr.length; i++) {
            if (list.contains(arr[i])) {
                list.remove(list.indexOf(arr[i]));
            } else {
                list.add(arr[i]);
            }
        }
        if (list.isEmpty()) {
            return -1;
        }
        int value = list.get(0);
        for (int j = 0; j < arr.length; j++) {
            if (arr[j] == value) {
                return j;
            }
        }
        return -1;
    }

}
