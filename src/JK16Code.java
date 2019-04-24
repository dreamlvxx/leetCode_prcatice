
public class JK16Code {
    /**
     * 在有重复元素的序列中，寻找第一个可以匹配的值
     */
    public int binarySearchFirst(int[] arr, int value) {
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (arr[mid] > value) {
                high = mid - 1;
            } else if (arr[mid] < value) {
                low = mid + 1;
            } else {
                if (mid == 0 || arr[mid - 1] != value) { //判断它的下标是不是0，前面已经没有元素，或者前面的元素不等于mid, 那么mid就是target
                    return mid;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }

    /**
     * 在有重复元素的序列中，寻找最后一个匹配的元素
     * @param arr
     * @param value
     * @return
     */
    public int binarySearchLast(int[] arr,int value){
        int low = 0;
        int high = arr.length - 1;
        while (low <= high){
            int mid = low + ((high - low) >> 1);
            if (arr[mid] < value){
                low = mid + 1;
            }else if (arr[mid] > value){
                high = mid - 1;
            }else{
                if (mid == arr.length - 1 || arr[mid + 1] != value){
                    return mid;
                }else{
                    low =  mid + 1;
                }
            }
        }
        return -1;
    }

    /**
     * 在有重复元素的序列中，寻找第一个大于给定值的元素
     * @param arr
     * @param value
     * @return
     */
    public int binarySearchFirstBig(int[] arr,int value){
        int low = 0;
        int high = arr.length - 1;
        while (low <= high){
            int mid = low + ((high - low) >> 1);
            if (arr[mid] < value){
                low = mid + 1;
            }else{
                if (mid == 0 || arr[mid - 1] < value){
                    return mid;
                }else{
                    high = mid - 1;
                }
            }
        }
        return -1;
    }

    /**
     * 在有重复元素的序列中，寻找最后一个小于给定值的元素
     * @param arr
     * @param value
     * @return
     */
    public int binarySearchLastBig(int[] arr,int value){
        int low = 0;
        int high = arr.length - 1;
        while (low <= high){
            int mid = low + ((high - low) >> 1);
            if (arr[mid] > value){
                high = mid - 1;
            }else{
                if (mid == arr.length - 1 ||arr[mid + 1] > value){
                    return mid;
                }else{
                    low = mid + 1;
                }
            }
        }
        return -1;
    }
}
