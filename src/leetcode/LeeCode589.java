package leetcode;

import java.util.ArrayList;
import java.util.List;

public class LeeCode589 {
    class Node {
        public int val;
        public List<Node> children;
        public Node() {}
        public Node(int _val,List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
    public List<Integer> preorder(Node root) {
        if (root == null) return new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        res.add(root.val);
        if (root.children != null
                &&root.children.size() > 0 ){
            for (int i = 0; i < root.children.size(); i++) {
                res.addAll(preorder(root.children.get(i)));
            }
        }
        return res;
    }
}
