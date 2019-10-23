package leetcode;

import java.util.HashMap;
import java.util.Stack;

/**
 *
 */
public class LeeCode20 {
    public boolean isValid(String s) {
        if (null == s || s.length() == 0)return true;
        HashMap<Character,Character> map = new HashMap<>();
        map.put(']','[');
        map.put('}','{');
        map.put(')','(');

        Stack<Character> stack = new Stack();
        for (int i = 0; i < s.length(); i++) {
            if (stack.size() == 0){
                stack.push(s.charAt(i));
            }else{
                if (map.get(s.charAt(i)) != null){
                    char c = stack.peek();
                    if (c == map.get(s.charAt(i))){
                        stack.pop();
                    }else{
                        stack.push(s.charAt(i));
                    }
                }else{
                    stack.push(s.charAt(i));
                }
            }
        }
        return stack.size() == 0;
    }

    public boolean isValid2(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (char c : s.toCharArray()) {
            if (c == '(')
                stack.push(')');
            else if (c == '{')
                stack.push('}');
            else if (c == '[')
                stack.push(']');
            else if (stack.isEmpty() || stack.pop() != c)
                return false;
        }
        return stack.isEmpty();
    }


}
