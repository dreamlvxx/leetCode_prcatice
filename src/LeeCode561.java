public class LeeCode561 {
    public static int arrayPairSum(int[] nums) {
        int res = 0;
        if (nums.length == 0 && nums == null) {
            return res;
        }
        quickSort(nums,nums.length);

        for (int i = 0; i < nums.length; i+=2) {
            res += nums[i];
        }
        return res;
    }

    public static void quickSort(int[] nums,int n){
        quick(nums,0,n - 1);
    }

    public static void quick(int[] nums,int start ,int end){
        if (start >= end)return;
        int pos = patition(nums,start,end);
        quick(nums,start,pos - 1);
        quick(nums,pos + 1,end);
    }

    public static int patition(int[] nums,int start,int end){
        int res = nums[end];
        int st = start;
        for (int i = start; i <= end - 1; i++) {
            if (nums[i] < res){
                int tem = nums[i];
                nums[i] = nums[st];
                nums[st] = tem;
                st ++ ;
            }
        }
        int tem = nums[st];
        nums[st] = nums[end];
        nums[end] = tem;
        return st;
    }
}
