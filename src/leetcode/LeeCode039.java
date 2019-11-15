package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeeCode039 {
    //构造一个结果变量
    List<List<Integer>> result = new ArrayList();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);//进行一下排序，方便后面从小到大添加，主要便于38的操作。
        find(candidates,target,0,new ArrayList());
        return result;
    }

    public void find(int[] arr,int target,int sum,ArrayList<Integer> res){
        int i = 0; //这里定义一个开始在集合中的什么位置
        if(res.size() > 0){
            for(int j = 0;j < arr.length; ++j){
                if(res.get(res.size() - 1) == arr[j]){
                    i = j;
                }
            }
        }

        for(;i < arr.length; ++ i){//遍历数组arr添加可以累加的数字，分三种情况进行处理。
            if(sum + arr[i] == target){//加当前值正好等于target，添加到结果集中。
                res.add(arr[i]);
                result.add(res);
            }
            if(sum + arr[i] < target){//加当前值小于target，添加进来临时结果，再进行递归寻找
                int s = sum;
                s += arr[i];
                ArrayList<Integer> list = new ArrayList(res);
                list.add(arr[i]);
                find(arr,target,s,list);
            }
            if(sum + arr[i] > target){//加当前值大于，说明已经无法再添加了，后面的更大
                return;
            }
        }
    }
}
