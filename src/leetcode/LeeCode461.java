package leetcode;

public class LeeCode461 {
    public int hammingDistanceMine(int x, int y) {
        int maxLevel = 30;
        int diff = 0;
        while (maxLevel >= 0){
            int xIs = 0;
            int yIs = 0;
            if (x >= Math.pow(2,maxLevel)){
                x -= Math.pow(2,maxLevel);
                xIs = 1;
            }
            if (y >= Math.pow(2,maxLevel)){
                y -= Math.pow(2,maxLevel);
                yIs = 1;
            }

            if ((xIs ^ yIs ) == 1){
                diff ++;
            }

            maxLevel--;
        }
        return diff;
    }

    public int hammingDistance(int x, int y) {
        int xor = x ^ y, count = 0;
        for (int i=0;i<32;i++) count += (xor >> i) & 1;
        return count;
    }
}
