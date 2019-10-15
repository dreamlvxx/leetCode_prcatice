/**
 * f(1) = 1 f(2) = 1
 *  f(n) = f(n - 1) + f(n - 2)
 * 大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0）。
 * n<=39
 */
public class Offer07 {
    //递归解决
    public int Fibonacci(int n) {
        if(n == 1 || n == 2){
            return 1;
        }
        return Fibonacci(n -1) + Fibonacci(n - 2);
    }

    //遍历解决
    public int Fibonacci1(int n) {
        if(n == 0){
            return 0;
        }else if(n == 1){
            return 1;
        }
        int sum = 1;
        int one = 0;
        for(int i=2;i<=n;i++){
            sum = sum + one;
            one = sum - one;
        }
        return sum;
    }
}
