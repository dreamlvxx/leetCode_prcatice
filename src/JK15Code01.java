/**
 * 二分查找
 */
public class JK15Code01 {
    //迭代实现
    public int binarySearch(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;//防止数字溢出，选择这种/2方式
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] > target) {
                high = mid - 1;
            } else if (arr[mid] < target) {
                low = mid + 1;
            }
        }
        return -1;
    }


    //递归实现二分查找
    public int binarySearch1(int[] arr,int value) {
        return binarySearchInter(arr,0,arr.length - 1,value);
    }

    public int binarySearchInter(int[] arr, int low, int high, int value) {
        if (low > high) return -1;
        int mid = low + (high - low) / 2;
        if (arr[mid] == value) {
            return mid;
        } else if (arr[mid] > value) {
            return binarySearchInter(arr, 0, mid - 1, value);
        } else {
            return binarySearchInter(arr, mid + 1, high, value);
        }
    }
}
