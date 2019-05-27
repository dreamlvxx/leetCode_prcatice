import java.util.HashMap;

/**
 *
 */
public class LeeCode338 {
    //通过之前求得的值，可以推理现在的值
    public int[] countBitsMine(int num) {
        int mark = 1;
        int[] res = new int[num + 1];
        res[0] = 0;
        HashMap<Integer, Integer> map = new HashMap<>();//这个可以省略,直接用res即可。
        map.put(0,0);
        for (int i = 1; i < num; i++) {
            if (mark * 2 == i) {
                map.put(i, 1);
                res[i] = 1;
                mark = i;
            } else {
                int temp = i - mark;
                int va = 1 + map.get(temp);
                map.put(i, va);
                res[i] = va;
            }
        }
        return res;
    }

    //最优解法  其实与上面的思路是一样的  写法不同。
    public int[] countBits(int num) {
        int[] f = new int[num + 1];
        for (int i=1; i<=num; i++) f[i] = f[i >> 1] + (i & 1);
        return f;
    }
}
