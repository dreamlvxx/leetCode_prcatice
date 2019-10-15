/**
 * 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 */
public class Offer11 {

    /**
     * 这个是最优解
     * 这个方式比较特别了，
     * 利用了n = (n - 1) & n   可以把每一个最后的1降位，然后再与自己相与，就可以抹除一个1,那么循环几次，就有几个1
     * @param n
     * @return
     */
    public static int NumberOf11(int n) {
        int count = 0;
        while (n != 0) {
            ++count;
            n = (n - 1) & n;
        }
        return count;
    }


    /**
     * 这种方式会造成死循环，因为如果是负数，那么右移补位是1
     * 这里可以采用>>> 无符号右移动解决
     * @param n
     * @return
     */
    public static int NumberOf1_CanNotUse(int n) {
        int count = 0;
        while (n != 0) {
            /*
             * 用1和n进行位与运算，
             * 结果要是为1则n的2进制形式
             * 最右边那位肯定是1，否则为0
             */
            if ((n & 1) == 1) {
                count++;
            }
            //把n的2进制形式往右推一位
            n = n >> 1;
        }
        return count;
    }

    /**
     * 用一个flag一直左移，然后对应每一位进行比对，等移动32次后，flag就变成了0
     */
    public int NumberOf1(int n) {
        int count = 0;
        int flag = 1;
        while (flag != 0) {
            if ((n & flag) != 0) {
                count++;
            }
            flag = flag << 1;
        }
        return count;
    }

}
