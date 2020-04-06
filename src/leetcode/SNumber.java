package leetcode;

/**
 * 整型无序数组a，第i下标的值为ai，找任意一对下标（i,j）使得i<j 且ai<aj
 */
public class SNumber {

    public static void main(String[] args) {
        int[] arr = {7,2,5,4,8,9,10};
        aaa(arr);
    }

    public static void aaa(int[] arr){
        find(arr);
        System.out.println(a + "--" + b);
    }

    static int a,b;
    public static void find(int[] arr){
        if (null == arr || arr.length < 2){
            return;
        }
        a = arr[0];
        for(int i = 1;i < arr.length; ++ i){
            if (arr[i] > a){
                b = arr[i];
                return;
            }else{
                a = arr[i];
            }
        }

    }
}
