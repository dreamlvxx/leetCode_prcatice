package leetcode;

public class LeeCode832 {
    public int[][] flipAndInvertImage(int[][] A) {
        int[][] B = new int[A.length][];
        for (int i = 0; i < A.length; i++) {
            B[i] = solveArr(A[i]);
        }
        return B;
    }

    public int[] solveArr(int[] A){
        int[] B = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            B[i] = Math.abs(A[A.length - i - 1] - 1);
        }
        return B;
    }
}
