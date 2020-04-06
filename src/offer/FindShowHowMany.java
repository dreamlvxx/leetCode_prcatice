package offer;


/**
 * 统计一个数字在【排序】【数组】中出现的次数。
 */
public class FindShowHowMany {
    public int GetNumberOfK(int [] array , int k) {
        return binarySearch(array,k + 0.5) - binarySearch(array,k - 0.5);
    }

    public int binarySearch(int[] arr,double target){
        int left = 0;
        int right = arr.length - 1;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(arr[mid] > target){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return left;
    }
}
