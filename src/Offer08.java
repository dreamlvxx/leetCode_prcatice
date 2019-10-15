public class Offer08 {
    //循环实现
    public int JumpFloor(int target) {
        if (target == 1){
            return 1;
        }
        if (target == 2){
            return 2;
        }
        int a = 2;
        int b = 1;
        for (int i = 3; i <= target; i++) {
            a = a + b;
            b = a - b;
        }
        return a;
    }
}
