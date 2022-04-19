package other_demo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Number100Random {
    private static int range = 100;
    private static ArrayList<Integer> originalList = new ArrayList<Integer>();
    private static ArrayList<Integer> result = new ArrayList<Integer>();

    static {
        for (int i = 1; i <= range; i++) {
            originalList.add(i);
        }
    }

    public static void main(String args[]) {
        for (int i = 0; i < range; i++) {
            int j = range - i;
            int r = (int) (new Random().nextInt(j));

            result.add(originalList.get(r));

            System.out.print(originalList.get(r) + ", ");
            originalList.remove(r);
        }

        Collections.sort(result);
        System.out.println("\n\n生成的数组大小是：" + result.size() + "------以下是排序结果，看是否有重复的随机数");
        for (Integer i : result) {
            System.out.print(i + ", ");
        }
    }



}
