package offer;

import java.util.Collections;
import java.util.List;

/**
 * https://leetcode.cn/problems/569nqc/
 */
public class Offer035 {
    public int findMinDifference(List<String> timePoints) {
        if(null == timePoints)return 0;
        Collections.sort(timePoints);
        int res = Integer.MAX_VALUE;
        String[] arr0 = timePoints.get(0).split(":");

        int t0Min = Integer.parseInt(arr0[0]) * 60 + Integer.parseInt(arr0[1]);
        int preMin = t0Min;
        for(int i = 1;i < timePoints.size();i ++) {
            String[] arr = timePoints.get(i).split(":");
            int minutes = Integer.parseInt(arr[0]) * 60 + Integer.parseInt(arr[1]);
            res = Math.min(res,minutes - preMin);
            preMin = minutes;
        }
        res = Math.min(res,t0Min + 1440 - preMin);
        return res;

    }
}
