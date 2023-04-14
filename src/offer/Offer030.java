package offer;

import java.util.*;

/**
 * https://leetcode.cn/problems/FortPu/
 */
public class Offer030 {
    Map<Integer,Integer> map;
    List<Integer> list;
    Random random;
    /** Initialize your data structure here. */
    public Offer030() {
        map = new HashMap();
        list = new ArrayList();
        random = new Random();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(map.containsKey(val)){
            return false;
        }
        int index = list.size();
        map.put(val,index);
        list.add(val);
        return true;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(!map.containsKey(val)){
            return false;
        }
        int index = map.get(val);
        int last = list.get(list.size() - 1);
        list.set(index,last);
        map.put(last,index);
        map.remove(val);
        list.remove(list.size() - 1);
        return true;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        int index = random.nextInt(list.size());
        return list.get(index);
    }
}
