package dp_study_project;

public class LeetCode_cn_1014 {

    /**
     * 关键在于吧values[i] + values[j] + i - j 转化为 values[i] + i + values[j] - j
     * 把相关的变量信息放在一起，便于处理
     * @param values
     * @return
     */
    public int maxScoreSightseeingPair(int[] values) {
        int n = values.length;
        int res = 0;
        int max = values[0] + 0;
        for(int i = 1;i < n;i++){
            res = Math.max(res,max + (values[i] - i));
            max = Math.max(max,values[i] + i);
        }
        return res;
    }

}
