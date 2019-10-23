package leetcode;

import java.util.HashSet;

public class LeeCode929 {
    public static int numUniqueEmails(String[] emails) {
        HashSet<String> strHashSet = new HashSet<>();//利用hashSet去重的特性
        for (int i = 0; i < emails.length; i++) {
            strHashSet.add(fliterStr(emails[i]));
        }
        System.out.println(strHashSet);
        return strHashSet.size();
    }
    public static String fliterStr(String s){
        int atIndex = s.indexOf("@");
        String preStr = s.substring(0,atIndex);
        preStr = preStr.replace(".","");//去除.符号
        if (preStr.contains("+")){//去除+号后面的字符串
            int plusIndex = preStr.indexOf("+");
            preStr = preStr.substring(0,plusIndex);
        }
        return preStr + s.substring(atIndex);
    }
}
