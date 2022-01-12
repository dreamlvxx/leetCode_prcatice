package jz_offer_studp_project;

import java.util.ArrayList;
import java.util.List;

public class JZ_cn_081 {
    List<List<Integer>> res;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        res = new ArrayList<>();
        find(candidates,target,0,new ArrayList<Integer>());
        return res;
    }

    public void find(int[] arr,int target,int idx,List<Integer> list){
        if(target < 0){
            return ;
        }
        if(target == 0){
            System.out.println(list);
            res.add(new ArrayList<>(list));
            return;
        }
        for(int i = idx;i < arr.length;i ++){
            list.add(arr[i]);
            find(arr,target - arr[i],i,list);
            list.remove(list.size() - 1);
        }
    }
}
