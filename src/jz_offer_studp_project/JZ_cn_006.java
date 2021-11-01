package jz_offer_studp_project;

public class JZ_cn_006 {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;
        while(left < right){
            int sum = numbers[left] + numbers[right];
            if(sum == target){
                return new int[]{left,right};
            }else if(sum < target){
                left ++;
            }else{
                right --;
            }
        }
        return new int[]{-1,-1};
    }
}
