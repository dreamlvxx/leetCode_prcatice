package leetcode;

public class LeeCode852 {
    public int peakIndexInMountainArray(int[] A) {
        int max = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] >= A[max]){
                max = i;
            }
        }
        return max;
    }
}
