/**
 * 计算一个数组的有序度,利用归并
 */
public class JK38Code1 {
    private int num = 0; //有序度计数器
    public int count(int[] a,int n){
        mergeSortCounting(a,0,n-1); // a 表示起点 n -1表示终点
        return num;
    }
    private void mergeSortCounting(int[] a,int p ,int r){
        if (p >= r)return;
        int q = (p + r) / 2; //q 表示中间点 划分为前后两部分
        mergeSortCounting(a,0,q); //计算前半部分的有序度
        mergeSortCounting(a,q + 1,r);//计算后半部分的有序度
        merge(a,p,q,r);//计算前后两部分之间的有序度，利用合并过程计算
    }

    private void merge(int[] a ,int p,int q,int r){
        int[] tmp = new int[r - p + 1];//构建一个临时数组
        int i = p,j = q + 1,k = 0; //i在前半部分滑动的指针 j在后半部分滑动的指针 k代表临时数组的指针
        while (i <= q && j <= r ){ //终止条件是某一个指针已经到了终点
            if (a[i] <= a[j]){//当前 i j指针指向的数值进行比较，如果前面的小 有序，那么i指针向前移动一个
                tmp[k ++] = a[i ++];
            }else{
                num += q - i + 1;
                tmp[k ++] = a[j ++];
            }
        }

        while (i <= q){ //j指针已经到达  剩下的i  copy到 k
            tmp[k ++] = a[i ++];
        }

        while (j <= r){//i指针已经到达  剩下的j  copy到 k
            tmp[k ++] = a[j ++];
        }

        for (int l = 0; l < r - p; l++) {//最后排序好的数组
            a[p + l] = tmp[i];
        }
    }
}
