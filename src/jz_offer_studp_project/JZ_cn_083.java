package jz_offer_studp_project;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class JZ_cn_083 {
    List<List<Integer>> res = new ArrayList();
    int n = 0;
    public List<List<Integer>> permute(int[] nums) {
        List<Integer> output = new ArrayList<>();
        n = nums.length;
        for (int num : nums) {
            output.add(num);
        }
        find(0,output);
        return res;
    }

    void find(int idx,List<Integer> list){
        if(idx == n){
            res.add(new ArrayList<>(list));
            return;
        }
        for(int i = idx;i < n;i ++){
            Collections.swap(list,idx,i);
            find(idx + 1,list);
            Collections.swap(list,idx,i);
        }
    }
}
