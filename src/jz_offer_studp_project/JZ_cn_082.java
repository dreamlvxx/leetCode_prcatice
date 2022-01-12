package jz_offer_studp_project;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JZ_cn_082 {
    List<List<Integer>> res = new ArrayList();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        find(candidates,target,0,new ArrayList<Integer>());
        return res;
    }

    public void find(int[] arr,int target,int idx,List<Integer> list){
        if(target < 0){
            return ;
        }
        if(target == 0){
            res.add(new ArrayList<Integer>(list));
            return;
        }
        for(int i = idx;i < arr.length;i ++){
            if(i > idx && arr[i] == arr[i - 1]){
                continue;
            }
            list.add(arr[i]);
            find(arr,target - arr[i],i + 1,list);
            list.remove(list.size() - 1);
        }
    }
}
