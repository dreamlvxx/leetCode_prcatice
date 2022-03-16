package jz_offer_studp_project;

public class JZ_cn_010 {
    public int subarraySum(int[] nums, int k) {
        int[] pre = new int[nums.length + 1];

        for (int i = 1; i <= nums.length; i++) {
            pre[i] = pre[i - 1] + nums[i - 1];
        }

        int res = 0;
        for (int left = 0; left < nums.length; left++) {
            for (int right = left; right < nums.length; right++) {
                if (pre[right + 1] - pre[left] == k) {
                    res++;
                }
            }
        }
        return res;
    }
}
