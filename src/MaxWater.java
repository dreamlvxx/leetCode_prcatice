/**
 *
 */
public class MaxWater {
    public static void main(String[] args) {
        int[] ls = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        int l = ls.length;
        int s;
        int max = 0;
        int i = 0;
        int j = l - 1;
        while (i < j) {
            s = (j - i) * Math.min(ls[i], ls[j]);
            //注意区分直接使用i++,j--的作用
            if (ls[i] < ls[j]) {
                i++;
            } else {
                j--;
            }
            if (s > max) {
                max = s;
            }
        }
        System.out.println("最大值：" + max);
    }
}
