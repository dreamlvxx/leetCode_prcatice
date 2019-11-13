package offer;

public class AddToMin {
    public String PrintMinNumber(int [] numbers) {
        //进行一次排序，高位小的从小到达排，高位相同的，再根据次位排。最后拼接即可。
        for(int i = 1;i < numbers.length;i ++){
            int temp = numbers[i];
            for(int j = i - 1;j > 0; j --){
                if(numbers[j] < numbers[i] ){

                }
            }
        }
        return "";
    }
}
