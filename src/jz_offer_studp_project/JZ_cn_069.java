package jz_offer_studp_project;

public class JZ_cn_069 {
    public int peakIndexInMountainArray(int[] arr) {
        int res = -1;
        for(int i = 1;i < arr.length;i ++ ){
            if(arr[i] < arr[i - 1]){
                return i - 1;
            }
        }
        return res;
    }
}
