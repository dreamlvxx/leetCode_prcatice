package leetcode;

import kotlin.text.Charsets;

import java.nio.charset.Charset;

public class LeeCode14 {

    public static void main(String[] args) {
        String a = new String("sss".getBytes());
    }

    //Horizontal scanning  数组从头到尾检查
    public String longestCommonPrefix(String[] strs) {
        if (null == strs || strs.length == 0) return "";
        String pre = strs[0];//第一个子串做当是公共串，从第二个传开始匹配，看里面有没有此子串，然后从尾部不断减少子串长度 直到匹配位置
        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(pre) != 0) {
                pre = pre.substring(0, pre.length() - 1);
                if (pre.isEmpty()) return "";
            }
        }
        return pre;
    }

    //Vertical Scanning 将第一个当做预备串，拿每一个字符 在后面的子串中进行对比，是否能匹配，相当于把所有子串竖直排列，一个一个推着前进。
    public String longestCommonPrefix02(String[] strs) {
        if (null == strs || strs.length == 0) return "";
        for (int i = 0; i < strs[0].length(); i++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (i == strs[j].length() || strs[j].charAt(i) != c) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];
    }

    //分而治之  类似归并排序的思想
    public String longestCommonPrefix03(String[] strs) {
        if (null == strs || strs.length == 0) return "";
        return dividerCommonPre(strs, 0, strs.length - 1);
    }

    public String dividerCommonPre(String[] strs, int start, int end) {
        if (start == end) return strs[start];
        int mid = (start + end) / 2;
        String left = dividerCommonPre(strs, start, mid);
        String right = dividerCommonPre(strs, mid, end);
        return commonFix(left, right);
    }

    public String commonFix(String left, String right) {
        String pre = left;
        while (right.indexOf(pre) != 0) {
            pre = pre.substring(0, pre.length() - 1);
            if (pre.isEmpty()) return "";
        }
        return pre;
    }

    //二分查找 这个就牛逼了 Time complexity : O((S⋅log(n)) S是strs的length  Space complexity : O(1)
    public String binarySearchCommonPre(String[] strs) {
        if (null == strs || strs.length == 0) return "";
        int minLength = Integer.MAX_VALUE;
        for (String s : strs) {
            if (s.length() < minLength){
                minLength = s.length();
            }
        }
        int low = 1;
        int hight = minLength;

        while (low <= hight){
            int mid = (low + hight) / 2;
            if (isCommonPre(strs,mid)){
                low = mid + 1;
            }else{
                hight = mid - 1;
            }
        }
        return strs[0].substring(0,(low + hight) / 2);
    }

    public boolean isCommonPre(String[] strs, int end) {
        String str1 = strs[0].substring(0,end);
        for (int i = 1; i < strs.length; i++)
            if (!strs[i].startsWith(str1))
                return false;
        return true;
    }



}
