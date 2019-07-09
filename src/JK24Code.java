public class JK24Code {

    public class Node{
        int val;
        Node left;
        Node right;

        public Node(int val){
            this.val = val;
        }
    }

    //二叉查找树的查找节点
    private Node root;
    public Node find(int data){
        Node p = root;
        while (p != null ){
            if (p.val > data){
                p = p.left;
            }else if(p.val < data){
                p = p.right;
            }else{
                return p;
            }
        }
        return null;
    }

    //二叉查找树的节点插入
    public void insert(int data){
        if (root == null){
            root = new Node(data);
        }
        Node p = root;
        while (p !=null){
            if (p.val > data){
                if (p.left == null){
                    p.left = new Node(data);
                    return;
                }else{
                    p = p.left;
                }
            }else{
                if (p.right == null){
                    p.right = new Node(data);
                    return;
                }else{
                    p = p.right;
                }
            }
        }
    }

    //二叉查找树的节点删除
    public void delete(int data){
        Node p = root;
        Node pp =  null;
        while (p != null && p.val != data){
            if (p.val > data){
                p = p.left;
            }else{
                p = p.right;
            }
            pp = p;
        }

        if (p == null){
            return;
        }

        if (p.right != null && p.left !=null){//这种情况先处理成删除只有一个节点或者叶子节点的问题
            Node minP = p.right;
            Node minPP = p;// minPP是minP的父节点

            while (minP.left != null ){
                minP = minP.left;
                minPP = minP;
            }

            p.val = minP.val; //将最小的值替换上去
            p = minP;//这里把本来找到的要删除的节点，指向找到的最小的节点
            pp = minPP;//父节点也相应变化过去
        }

        //下面这段代码就是看一下将要删除的节点，挂了一串子树是什么
        Node child = null;
        if (p.left != null){
            child = p.left;
        }else if(p.right != null){
            child = p.right;
        }else{
            child = null;
        }

        //下面这段代码，是把将要删除的节点的父节点，直接连接上刚才的一串子树
        if (pp == null){
            root = child;
        }else if(pp.left == p){
            pp.left = child;
        }else{
            pp.right = child;
        }

    }


}
