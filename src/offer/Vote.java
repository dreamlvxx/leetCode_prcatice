package offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Vote {
    public int MoreThanHalfNum_Solution(int [] array) {
        ArrayList<Integer> list = new ArrayList();
        for(int i = 0;i < array.length ; i ++ ){
            if(list.isEmpty()){
                list.add(array[i]);
            }else{
                if(array[i] == list.get(0)){
                    list.add(array[i]);
                }else{
                    list.remove(0);
                }
            }
        }
        if(list.size() == 1){
            int count = 0;
            int target = list.get(0);
            for(int j = 0;j < array.length ; j ++){
                if(array[j] == target){
                    count ++;
                }
            }
            if(count > array.length / 2){
                return target;
            }else{
                list.clear();
            }
        }
        return list.isEmpty()? 0 : list.get(0);
    }


}
