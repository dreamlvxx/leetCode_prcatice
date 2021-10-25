package offer;

/**
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
 * 使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，
 * 并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 */
public class JZ21 {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7};
        reOrderArray(arr);
    }

    /**
     * 类似于快速排序的分点函数
     * @param array
     */
    public static void reOrderArray(int [] array) {
        //定义一个奇偶分界线
        int cur = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 != 0){
                swap(array,cur,i);
                cur ++;
            }
        }
    }

    //根据分界线，将遍历的i位置的奇数放到分界线左边
    private static void swap(int[] arr,int cur,int i){
        int temp = arr[i];
        while(i != cur){
            arr[i] = arr[i - 1];
            i --;
        }
        arr[cur] = temp;
    }


    //==========================
    public void oder1(int[] numbers){
        if (numbers.length == 0){
            return;
        }
        int curr = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[curr] % 2 != 0){
                 swap(numbers,curr,i);
                 curr++;
            }
        }
    }

    public void swap1(int[] arr,int curr,int i){
        int currValue = arr[i];
        while (i != curr){
            arr[i] = arr[i - 1];
            i --;
        }
        arr[curr] = currValue;
    }


}
