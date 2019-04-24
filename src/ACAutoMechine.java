import java.util.LinkedList;
import java.util.Queue;

public class ACAutoMechine {
    //trie树的建立这里没写代码
    public AcNode root;
    /**
     * AC自动机的数据模型
     */
    public class AcNode{
        public char data;
        public AcNode[] children = new AcNode[26];
        public boolean isEndingChar = false; //这个字符是否是结尾字符
        public int length = -1; //当isEndingChar = true的时候，记录模式串长度
        public AcNode fail; //失败指针
        public AcNode(char data){
            this.data = data;
        }
    }

    /**
     * AC自动机失败指针的构建
     */
    public void buildFailurePointer(){
        Queue<AcNode> queue = new LinkedList<>();
        root.fail = null;//root的失败指针是null
        queue.add(root);
        while (!queue.isEmpty()){
            AcNode p = queue.remove();//给p找到之后，p不用再继续遍历了，直接删除就好
            for (int i = 0; i < 26; i++) {
                AcNode pc = p.children[i];
                if (pc == null) continue;//没有对应26个字母的子节点 寻找下一个  就是从a-z寻找节点
                //这里之下是处理子节点pc的fail的逻辑，分情况：p是root p不是root
                if (p == root){
                    pc.fail = root;
                }else{
                    AcNode q = p.fail;//这里找到p的fail，

                    while (q != null){//p的fail不是空的情况下 寻找pc的fail
                        AcNode qc = q.children[pc.data - 'a'];//这个就是看q的子节点中，有没有和p的子节点pc相同的
                        if (qc != null){//q的子节点中存在和pc相同的子节点qc节点
                            pc.fail = qc;//既然有说明pc的fail就是qc的子节点的fail寻找到此结束
                            break;
                        }
                        q = q.fail; //走到这里说明qc并等于pc  所以要去q对应的fail中去寻找，直到找到为止
                    }

                    if (q == null){ //走到这里说明在q的fail，以及在fail的fail... ... 直到最后的fail到root都没找到，说明就没有可以匹配的fail
                        pc.fail = root;
                    }
                }
                queue.add(pc);//最后这个是for循环寻找子节点的时候，把当前的子节点也加进去，然后继续while的时候寻找pc的子节点的fail
            }
        }
    }

    /**
     * 匹配敏感词
     */
    public void match(char[] text){
        int n = text.length;
        AcNode p = root;
        for (int i = 0; i < n; i++) {
            int idx = text[i] - 'a';//这个序号是对应a-z下标
            while (p.children[idx] == null && p != root){
                p = p.fail;
            }
            p = p.children[idx];
            if (p == null) p = root;
            AcNode tmp = p;
            while (tmp != root){//这里判断当前p指向的节点，是否为结束节点，是的话就打印，然年再依次判断它的fail指针指向的节点是否是结束节点，是的话打印
                if (tmp.isEndingChar){
                    int pos = i - tmp.length + 1;
                    System.out.println("匹配下标是" + pos + "长度是" + tmp.length);
                }
               tmp = tmp.fail;
            }
        }
    }

}
