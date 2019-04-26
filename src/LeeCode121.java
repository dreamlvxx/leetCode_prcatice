/**
 * Input: [7,1,5,3,6,4]
 * Output: 5
 * Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
 * Not 7-1 = 6, as selling price needs to be larger than buying price.
 */
public class LeeCode121 {
    //利用俩指针，大小往后跑
    public int maxProfitMine(int[] prices) {
        if (null == prices || prices.length == 0)return 0;
        int min = 0;
        int max = 0;//（这个max指针其实有点多余，可以参考solution）
        int result = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < prices[min]){//判断i指向的值是不是小于当前的最小值
                if (i != prices.length - 1){//判断当前是不是最小的值，如果是最后一个值，那么如果当前是最小的，但是后面没有值，也不用移动了
                    min = i;
                    max = i;
                }
            }else{
                if (prices[max] < prices[i]){//大于max的才会更新
                    max = i;
                }
            }
            if (result < prices[max] - prices[min]){//可能遇到一个更小的值，但是后面的元素与它的差值小于之前的result
                result = prices[max] - prices[min];
            }
        }
        return result;
    }

    //solution
    public int maxProfit(int prices[]) {
        int minprice = Integer.MAX_VALUE;
        int maxprofit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minprice)
                minprice = prices[i];
            else if (prices[i] - minprice > maxprofit)
                maxprofit = prices[i] - minprice;
        }
        return maxprofit;
    }
}
