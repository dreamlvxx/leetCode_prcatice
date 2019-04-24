public class LeeCode011 {
    //先来个穷举法再说
    public int maxArea(int[] height) {
        int res = 0;
        for (int i = 0; i < height.length - 1; i++) {
            for (int j = i + 1; j < height.length; j++) {
                int m = (j - i) * Math.min(height[i],height[j]);
                if ( m > res){
                    res = m;
                }
            }
        }
        return res;
    }

    //***
    //Solution
    //Two Point Approach
    public int maxArea1(int[] height) {
        int res = 0;
        int start = 0;
        int end = height.length - 1;
        while(start < end){
            int mres = (end - start) * Math.min(height[start],height[end]);
            if (mres > res){
                res = mres;
            }
            if (height[start] >= height[end]){
                -- end;
            }else{
                ++ start;
            }
        }
        return res;
    }

}
