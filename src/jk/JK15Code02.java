package jk;

/**
 * 求解一个数的平方根，精度小数点后6位
 */
public class JK15Code02 {
    public int findGen(int target){
        int min,max;
        //首先根据target得值判断求解值的大致范围
        if (target < 1){
            min = target;
            max = 1;
        }else if (target == 1){
            return 1;
        }else{
            min = 1;
            max = target;
        }
        //二分查找求解
        while (min <= max){
            int mid = min + (max - min) / 2;
            if (mid * mid < target){
                min = mid;
            }else if (mid * mid > target){
                max = mid;
            }else if ((mid + 0.000001) * (mid + 0.000001) > target
                && (mid - 0.000001) * (mid - 0.000001) < target    //这里根据介值定理
            ){
                return mid;
            }
        }
        return -1;
    }
}
