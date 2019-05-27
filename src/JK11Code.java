import java.util.ArrayList;

/**
 * 插入 冒泡 选择排序算法
 * 归并 快速排序
 */
public class JK11Code {
    /**
     * 冒泡排序算法
     * 增加标识，当一次遍历没有交换的时候，说明已经到达了有序状态，提前退出。
     * 稳定的排序算法
     * 用到两种原子操作：比较，交换
     * @param arr
     * @return
     */
    public void bubbleSort(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            boolean hasSwap = false;
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]){
                    swap(arr,j,j + 1);
                    hasSwap = true;
                }
            }
            if (!hasSwap)break;
        }
    }

    /**
     * 选择排序
     * 原子操作：比较，交换
     * 不是稳定的算法
     *
     * 比冒泡效率高的原因：冒泡使用交换，涉及三个赋值操作，而插入使用移动，涉及一个赋值操作。
     * @param arr
     * @return
     */
    public int[] selectSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {//从i 到结尾 ，选取一个最小的min  与i位置的数据进行交换
            //选择一个最小的
            int min = i;
            for (int j = i + 1; j < arr.length; j++) {//寻找最小的数据的位置index
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }
            if (min > i){//交换
                swap(arr,min,i);
            }
        }
        return arr;
    }

    /**
     * 插入排序
     * 稳定的排序算法
     * 原子操作：比较，移动
     * @param arr
     * @return
     */
    public static void insertSort(int[] arr){
        for (int i = 1; i < arr.length; ++i) {//第一个for循环决定选取哪一个往前面排好的序列插入 ,index 从1 开始，默认第一个排序好了
            int value = arr[i];//暂时保存i这个位置的值，后面给空位补上
            int j = i - 1;
            for (; j >=0 ; --j) {
                if (arr[j] > value){//这里用移动，所以从i之前的第一个开始，如果大于i对应的值，那么就往后移动
                    arr[j + 1] = arr[j];
                }else{
                    break;//没有交换就结束了
                }
            }
            arr[j + 1] = value;//当前的值不再比较，留下的空位就是当前后面的一个
        }
    }

    /**
     * 希尔排序
     * @param arr
     */
    private void shellSort1(int[] arr) {
        int gap = arr.length / 2;
        while (gap >= 1) {
            for (int i = gap; i < arr.length; i++) {
                int value = arr[i];
                int j = i - gap;
                for (; j > 0; j = j - gap) {
                    if (arr[j] > value) {
                        arr[j + gap] = arr[j];
                    } else {
                        break;
                    }
                }
                arr[j + gap] = value;
            }
            gap = gap / 2;
        }
    }

    /**
     * 归并排序
     * 稳定的排序算法
     * 不是原地排序算法
     * 时间复杂度度是O(nlogn)
     * 空间复杂度：开辟一个临时数组，所以是O(n)
     */
    public void mergeSort(int[] arr){
        merge_sort(arr,0,arr.length);
    }

    private int[] merge_sort(int[] arr,int start,int end ){
        if (start >= end)return new int[arr[start]];
        int mid = start + end / 2;
        int[] l = merge_sort(arr,start,mid);
        int[] r = merge_sort(arr,mid + 1,end);
        //这个就是合并两个有序数组问题
       return merge(l,r);
    }

    /**
     * 这里是可以利用哨岗，在两个数组的后面分别添加一个最后一个相同的值，也就是最大值
     * 循环就变成了 两个哨岗 q r
     *  while (i < q || j < r){
     *             if (arr[i] <= arr[j] && i < q){
     *                 temp[++ t] = arr[++i];
     *             }else{
     *                 temp[++t] = arr[++j];
     *             }
     *         }
     * 依据此哨岗，不需要再另外处理剩下的部分。但是此处为数组，似乎不太适合（数组的长度不可变）
     * 这里给出用list的使用场景
     */
    public ArrayList<Integer> merge(ArrayList<Integer> arr, int start, int mid , ArrayList<Integer> temp){
        int i = start;//前半段指针
        int j = mid + 2;//后半段指针
        arr.add(mid,arr.get(mid));
        arr.add(arr.get(arr.size() - 1));
        while (i < mid + 1 || j < arr.size() - 1){
            if (arr.get(i) <= arr.get(j) && i < mid + 1){
                temp.add(arr.get(i));
                i ++;
            }else{
                temp.add(arr.get(j));
                j ++;
            }
        }
        return temp;
    }

    //常规的利用一个新数组完成合并
    private int[] merge(int[] l,int[] r){
        int[] result = new int[l.length + r.length];
        int p = 0;
        int lp = 0;
        int rp = 0;
        while (lp < l.length && rp < r.length) {
            result[p++] = l[lp] < r[rp] ? l[lp++] : r[rp++];
        }
        while (lp < l.length) {
            result[p++] = l[lp++];
        }
        while (rp < r.length) {
            result[p++] = r[rp++];
        }
        return result;
    }

    /**
     * 快速排序
     * 原地排序
     * 不是稳定的排序
     */
    public void quickSort(int[] arr,int start,int end){
        if (start >= end)return;
        int p = partition(arr,start,end);
        quickSort(arr,start,p);
        quickSort(arr,p + 1,end);
    }

    private int partition(int arr[],int start,int end){
        int pivot = arr[end];
        int areaIndex = start;
        for (int i = start; i < end - 1; i++) {
             if (arr[i] < pivot){
                 swap(arr,areaIndex,i);
                 areaIndex ++;
             }
        }
        swap(arr,areaIndex,pivot);
        return areaIndex;
    }

    private void swap(int[] arr,int i, int j){
        arr[i] = arr[j] + arr[i];
        arr[j] = arr[i] - arr[j];
        arr[i] = arr[i] - arr[j];
    }
}
