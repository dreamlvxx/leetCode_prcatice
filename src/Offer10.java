/**
 * 题目描述：我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
 */
public class Offer10 {
    /**
     * 画图分析摆放可以看出来，1 ，2的时候固定操作。
     * 3以上的时候，横的摆和竖的摆分别又会产生两种情况。
     * 那么就很类似斐波那切函数。
     * @param target
     * @return
     */
    public int RectCover(int target) {
        if (target <=0){
         return 0;
        }
        if (target <= 2){
            return target;
        }
        return RectCover(target - 1) + RectCover(target - 2);
    }
}
