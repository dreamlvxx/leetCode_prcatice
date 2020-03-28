package offer;

/**
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 */
public class Offer09 {

    public static void main(String[] args) {
        System.out.println(JumpFloorII(3));
    }
    /**
     * 链接：https://www.nowcoder.com/questionTerminal/22243d016f6b47f2a6928b4313c85387?f=discussion
     *
     *     f(n-1) = f(0) + f(1)+f(2)+f(3) + ... + f((n-1)-1) = f(0) + f(1) + f(2) + f(3) + ... + f(n-2)
     *
     *     f(n) = f(0) + f(1) + f(2) + f(3) + ... + f(n-2) + f(n-1) = f(n-1) + f(n-1)
     *     可以得出：
     *     f(n) = 2*f(n-1)
     *
     *                   | 1       ,(n=0 )
     *
     *       f(n) =     |  1       ,(n=1 )
     *
     *                  | 2*f(n-1),(n>=2)
     * @param target
     * @return
     */
    public static int JumpFloorII(int target) {
        if (target <= 0) {
            return -1;
        } else if (target == 1) {
            return 1;
        } else {
            return 2 * JumpFloorII(target - 1);
        }
    }
}
