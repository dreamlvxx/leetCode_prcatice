package offer;

import java.util.ArrayList;


/**
 * 题目描述：
 * 输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点），
 * 返回结果为复制后复杂链表的head。
 * （注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
 */
public class CopyRandomTree {
    public class RandomListNode {
        int label;
        RandomListNode next = null;
        RandomListNode random = null;

        RandomListNode(int label) {
            this.label = label;
        }
    }

    public RandomListNode Clone1(RandomListNode pHead) {
        if (pHead == null) {
            return null;
        }
        RandomListNode cur = pHead;
        //复制新的next节点
        while (cur != null) {
            RandomListNode newNode = new RandomListNode(cur.label);
            RandomListNode nextNode = cur.next;
            cur.next = newNode;
            newNode.next = nextNode;
            cur = nextNode;
        }
        //复制新的random节点
        RandomListNode curr = pHead;
        while (curr != null) {
            RandomListNode nNode = curr.next;
            RandomListNode randomOld = curr.random;
            nNode.random = randomOld.next;
            curr = curr.next.next;
        }


        //将原来的链表和新构造的链表继续拆分
        RandomListNode res = pHead.next;
        RandomListNode cur1 = res;
        pHead = pHead.next.next;
        while (pHead != null) {
            cur1.next = pHead;
            cur1 = cur1.next;
            pHead = pHead.next.next;
        }
        return res;
    }

    /**
     * 主要利用了ArrayList来找到next和random的指向关系
     *
     * @param pHead
     * @return
     */
    public RandomListNode Clone(RandomListNode pHead) {
        if (pHead == null) {
            return null;
        }
        //先copy出来一份
        ArrayList<RandomListNode> listOld = new ArrayList<>();
        while (pHead != null) {
            listOld.add(pHead);
            pHead = pHead.next;
        }

        //再copy一份listOld -> listNew
        ArrayList<RandomListNode> listNew = new ArrayList();
        for (int i = 0; i < listOld.size(); i++) {
            RandomListNode temp = new RandomListNode(listOld.get(i).label);
            listNew.add(temp);
        }
        //根据listOld的指向，完成listNew的指向
        for (int j = 0; j < listNew.size(); j++) {
            RandomListNode node = listNew.get(j);

            RandomListNode nextNodeInOld = listOld.get(j).next;
            if (nextNodeInOld == null) {
                node.next = null;
            } else {
                int nextIndex = listOld.indexOf(nextNodeInOld);
                node.next = listNew.get(nextIndex);
            }


            RandomListNode randomNodeInOld = listOld.get(j).random;
            if (randomNodeInOld == null) {
                node.random = null;
            } else {
                int randomIndex = listOld.indexOf(randomNodeInOld);
                node.random = listNew.get(randomIndex);
            }

        }
        return listNew.get(0);
    }
}
