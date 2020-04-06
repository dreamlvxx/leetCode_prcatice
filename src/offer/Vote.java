package offer;

import java.util.ArrayList;

/**
 * 题目描述：
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。
 * 由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
 */

public class Vote {
    public int MoreThanHalfNum_Solution(int[] array) {

        int n = 0;
        int ret = array[0];

        for (int i = 0; i < array.length; i++) {
            if (n == 0) {
                ret = array[i];
                n = 1;
            } else {
                if (ret == array[i]) {
                    n++;
                } else {
                    n--;
                }
            }
        }
        return ret;
    }
}

