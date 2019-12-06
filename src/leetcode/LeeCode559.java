package leetcode;

import java.util.Collections;
import java.util.List;

public class LeeCode559 {
    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    };

    public int maxDepth(Node root) {
        if(root == null){
            return 0;
        }
        int max = 0;

        for(int i = 0; i < root.children.size(); ++ i){
            Node d =  root.children.get(i);
            if(d != null){
                int m = maxDepth(d);
                if(m > max){
                    max = m;
                }
            }
        }
        return max + 1;

    }
}
