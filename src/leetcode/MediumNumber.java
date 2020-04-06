package leetcode;

public class MediumNumber {

    public static void main(String[] args) {
        int[] arr = {1,5,3,4,2,6,8,7,9};
        System.out.println(find(arr));
    }

    public int medi(int[] arr){
        if (null == arr || arr.length == 0){
            return -1;
        }
        int medium = arr.length >> 1;
        int left = 0;
        int right = arr.length - 1;
        int res = partition1(arr,left,right);

        while (res != medium){
            if(res < medium){
                res = partition1(arr,res + 1,right);
            }else {
                res = partition1(arr,left,res - 1);
            }
        }
        return res;
    }

    public int partition1(int[] arr,int start,int end){
       if (start >= end){
           return start;
       }
       int pivot = arr[end];
       int curr = start;
       for (int i = start;i <= end - 1; ++ i){
           if (arr[i] < pivot){
               swap(arr,curr,i);
               ++ curr;
           }
       }
       swap(arr,end,curr);
       return curr;
    }

    public void swap1(int[] arr,int le,int ri){
        int temp = arr[le];
        arr[le] = arr[ri];
        arr[ri] = temp;
    }


    public static int find(int[] arr) {
        if (null == arr || arr.length == 0) {
            return -1;
        }
        int me = arr.length / 2;

        int res = -1;
        int left = 0;
        int right = arr.length - 1;
        while (res != me) {
            res = partition(arr,left,right);
            if (res > me) {
                right = res - 1;
            } else if(res < me){
                left = res + 1;
            }
        }
        return arr[res];
    }

    private static int partition(int[]arr,int start,int end){
        int pivot = arr[end];
        int areaIndex = start;
        for (int i = start; i <= end - 1; i++) {
            if (arr[i] < pivot){
                swap(arr,areaIndex,i);
                ++ areaIndex;
            }
        }
        swap(arr,areaIndex,end);
        return areaIndex;
    }

    private static void swap(int[] arr,int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
