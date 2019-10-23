package leetcode;

import java.util.concurrent.locks.ReentrantLock;

public class LeeCode867 {
    //这个解法的循环次数是A[0].length
    public int[][] transpose(int[][] A) {
        int[][] res = new int[A[0].length][A.length];
        for (int i = 0; i < A[0].length; i++) {
            for (int j = 0; j < A.length; j++) {
                res[i][j] = A[j][i];
            }
        }
        return res;
    }

    //这个解法的循环次数是A.length
    public int[][] transpose1(int[][] A) {
        ReentrantLock reentrantLock = new ReentrantLock();
        int[][] res = new int[A[0].length][A.length];
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                res[j][i] = A[i][j];
            }
        }
        return res;
    }


}
