package offer;

import java.util.ArrayList;

public class PermutationAndCombination {
    public static void main(String[] args) {
        new PermutationAndCombination().Permutation("ab");
    }

    ArrayList<String> res = new ArrayList();
    int length = 0;
    public ArrayList<String> Permutation(String str) {
        if(str == ""){
            return res;
        }
        ArrayList<Character> listt = new ArrayList();//利用一个list  记录有多少char
        for(int i = 0;i < str.length();i ++){
            listt.add(str.charAt(i));
        }
        length = listt.size();
        if(listt.size() == 1){//单独处理size==1的情况
            res.add(listt.get(0) + "");
            return res;
        }
        f(listt,"");
        return res;
    }

    public void f(ArrayList<Character> list,String aa){
        if(list.size() == 0){
            return;
        }
        for(int i = 0;i < list.size(); i ++){
            String ss = aa;//用一个临时str，保存结果
            //用一个临时的list，保证remove之后for循环的list还是所有元素
            ArrayList<Character> temp = new ArrayList(list);
            ss += temp.remove(i);
            System.out.println(ss);
            if(ss.length() == length && !res.contains(ss)){
                res.add(ss);
            }
            f(temp,ss);
        }
    }
}
