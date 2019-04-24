import java.util.ArrayList;

public class LeeCode003 {
    //mine
    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        char[] arr = s.toCharArray();
        ArrayList<Character> temp = new ArrayList<>();//这里可以用HashSet优化，使用contain()做到O(1)的复杂度
        for (int i = 0; i < arr.length;) {
            temp.clear();
            for (int j = i; j < arr.length; j++) {
                if (temp.indexOf(arr[j]) == -1){
                    temp.add(arr[j]);//如果临时字符串中不包含，就加入
                }else{
                    i = i + temp.indexOf(arr[j]) + 1;//更新从哪个字符开始寻找最大长度字符串  更新为匹配已有的字符串的相同字符的下标的后一个开始
                    break;
                }
                if (temp.size() > max){//看当前的字符串是否超过
                    max = temp.size();
                }
                if (j == arr.length - 1){//当一直添加直到结尾的时候，就直接return
                    return max;
                }
            }
        }
        return max;
    }
}
