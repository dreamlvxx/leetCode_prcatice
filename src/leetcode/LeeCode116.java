package leetcode;

public class LeeCode116 {
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    ;


    /**
     * 递归解法
     *
     * @param root
     * @return
     */
    public Node connect(Node root) {
        if (null == root) {
            return null;
        }
        if (root.left != null) {
            root.left.next = root.right;
            if (root.next != null) {
                root.right.next = root.next.left;
            }
        }
        connect(root.left);
        connect(root.right);
        return root;
    }


    public Node connect1(Node root) {
        if (null == root) {
            return null;
        }

        Node start = root;
        while (start != null) {
            Node cur = start;
            while (cur != null) {
                if (cur.left != null) {
                    cur.left.next = cur.right;
                    if (cur.next != null && cur.right != null) {
                        cur.right.next = cur.next.left;
                    }
                }
                cur = cur.next;
            }
            start = start.left;
        }
        return root;
    }


    public Node connect2(Node root) {
        if (null == root) {
            return null;
        }
        Node start = root;
        while (start != null) {
            Node cur = start;
            //先找这一层的开始结点
            Node s = null;
            while (cur != null) {
                if (cur.left != null) {
                    s = cur.left;
                } else if (cur.right != null) {
                    s = cur.right;
                } else {
                    cur = cur.next;
                }
            }


            Node snext = s;
            while (snext != null) {


                //找到之后找next指向的结点
                if (snext == cur.left) {
                    if (cur.right != null) {
                        snext.next = cur.right;
                    }
                } else {

                    while (cur != null) {
                        if (cur.left != null) {
                            snext.next = cur.left;
                        } else if (cur.right != null) {
                            snext.next = cur.right;
                        } else {
                            cur = cur.next;
                        }
                    }
                }


                snext = snext.next;
            }


            start = s;
        }
        return root;
    }


}
