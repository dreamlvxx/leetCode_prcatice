package leetcode;

import java.util.ArrayList;
import java.util.List;


/**
 * 一个很重要的规律是，前缀子串中，“（” 的数量必然比 “）”的多。
 * 由此可以利用这个约束关系，通过递归构造一个一个符合条件的结果。
 * @param
 * @return
 */
public class LeeCode22 {

    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<String>();
        generateOneByOne("", list, n, n);
        return list;
    }
    public void generateOneByOne(String sublist, List<String> list, int left, int right){
        if(left > right){
            return;
        }
        if(left > 0){
            generateOneByOne( sublist + "(" , list, left-1, right);
        }
        if(right > 0){
            generateOneByOne( sublist + ")" , list, left, right-1);
        }
        if(left == 0 && right == 0){
            list.add(sublist);
            return;
        }
    }


    public List<String> generateParenthesis1(int n) {
        List<String> list = new ArrayList<String>();
        backtrack(list, "", 0, 0, n);
        return list;
    }

    public void backtrack(List<String> list, String str, int open, int close, int max){
        if(str.length() == max*2){
            list.add(str);
            return;
        }

        if(open < max){
            backtrack(list, str+"(", open+1, close, max);
        }
        if(close < open){//这里也是必须判断“（” 的数量要比“）”的多
            backtrack(list, str+")", open, close+1, max);
        }
    }


}
