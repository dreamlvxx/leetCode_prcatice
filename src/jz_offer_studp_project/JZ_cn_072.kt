package jz_offer_studp_project

class JZ_cn_072 {
    fun mySqrt(x: Int): Int {
        if(x == 0){
            return 0
        }
        if(x == 1){
            return 1
        }
        var left = 0
        var right = x / 2 + 1
        while (left <= right){
            val mid = left + (right - left shr 1)
            if(mid < x / mid){
                left = mid + 1;
            }else if(mid > x / mid){
                right = mid - 1;
            }else{
                return mid;
            }
        }
        return right
    }
}