package leetcode;

public class LeeCode117 {

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    };

    public Node connect(Node root) {
        if (null == root) {
            return null;
        }
        Node start = root;
        while (start != null) {
            Node cur = start;
            //先找下一层的开始结点
            Node s = null;
            while (cur != null) {
                if (cur.left != null) {
                    s = cur.left;
                    break;
                } else if (cur.right != null) {
                    s = cur.right;
                    break;
                } else {
                    cur = cur.next;
                }
            }
            //下面从这个几点开始，往后面依次连接
            Node snext = s;
            while (snext != null) {
                //找到之后找next指向的结点
                if (snext == cur.left) {//先处理当前结点是左结点的情况
                    if (cur.right != null) {
                        snext.next = cur.right;
                    }else{
                        cur = cur.next;
                        while (cur != null) {
                            if (cur.left != null) {
                                snext.next = cur.left;
                                break;
                            } else if (cur.right != null) {
                                snext.next = cur.right;
                                break;
                            } else {
                                cur = cur.next;
                            }
                        }
                    }
                } else {//不是左结点，肯定就是右边结点
                    cur = cur.next;//这个时候就去cur的下一个结点寻找被连接的next结点
                    while (cur != null) {
                        if (cur.left != null) {
                            snext.next = cur.left;
                            break;
                        } else if (cur.right != null) {
                            snext.next = cur.right;
                            break;
                        } else {
                            cur = cur.next;
                        }
                    }
                }
                //最后移动，继续链接
                snext = snext.next;
            }
            //移动到下一层的第一个结点
            start = s;
        }
        return root;
    }
}
