package offer;

/**
 * 题目描述：我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。请问用n个2*1的小矩形无重叠地覆盖一个【2*n】的大矩形，总共有多少种方法？
 */
public class JZ70 {
    /**
     * 画图分析摆放可以看出来，1 ，2的时候固定操作。
     * 3以上的时候，横的摆和竖的摆分别又会产生两种情况。
     *
     * 这个类比跳台阶的题目，小矩形分横竖摆放，分别会产生两种不同影响。
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

    public int allStep(int target){
        if (target == 0){
            return 0;
        }
        if (target == 1){
            return 1;
        }
        if (target == 2){
            return 2;
        }
        return allStep(target - 1) + allStep(target - 2);
    }
}
