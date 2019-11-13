package jk;

public class KMP {
    public static int kmp(char[] a,int n,char[]b,int m){
        int[] next = getNexts(b,m);
        int j = 0;
        for (int i = 0; i < n; i++) {
            while (j > 0 && a[i] != b[j]){ //这里每循环一次，就是J的一次更新，也就是模式串向前的一次移动
                j = next[j - 1] + 1;
            }
            /**
             * 最后的时候判断j和当前的i指向的是否对应，如果对应就向后移动一个字符
             */
            if (a[i] == b[j]){
                ++j;
            }

            /**
             * 如果此时j的值已经是模式串的长度，说明已经匹配，那么当前的i 减去 模式串的长度再加1就是可匹配的子串的开头字符所在下标
             */
            if (j == m){
                return i - m + 1;
            }
        }
        return -1;
    }


    public static int[] getNexts(char[] b,int m){
        int[] next = new int[m];
        next[0] = -1;
        int k = -1;
        for (int i = 1; i < m; i++) {//每一次循环找的就是当前前缀串的最长可匹配串
            while (k != -1 && b[k + 1] != b[i]){ // k != -1 代表判断当前子串的的时候，它的上一个子串有可匹配前缀串  b[k + 1] != b[i]  就是代表上一个可匹配子串的下一个字符不等于当前的末尾字符
                k = next[k];  //此处的循环不断更新k值  是在当前子串上一个子串的结尾无法匹配当前结尾的时候，在子串中继续寻找子串，看是否有结尾可匹配的子子串
            }
            /**
             * 经过while的不断循环,更新的k值是最后的不能继续更新的了
             * while的两个判断条件(可能找不到，即k=-1，可能找到匹配的)
             * 到这里之后，判断最后找到的k的下一个字符，是否可以和当前的尾巴b[i]匹配，匹配的话，说明[0,k] 就是[0,i]的最大可匹配前缀子串
             * ++k的解释如下：
             * 其实这里可以看出来while的俩循环如果是第二个条件跳出的，也就是肯定有匹配的，++ k的操作也就是把k跳到下一个字符，也就是[0,k],即k就是我们要找的字符
             * 而当第一个条件跳出的时候（k = -1）说明没有找到可匹配的子串（子串必须是大于2个字符）,但是可能第一个字符会匹配，那么，第一个字符也算是当前子串的可匹配最长前缀子串
             */
            if (b[k + 1] == b[i]){
                ++ k;
            }
            next[i] = k;
        }
        return next;
    }
}