package offer;

import java.util.ArrayList;
import java.util.Random;

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
        //先进行复制相邻结点
        while (cur != null) {
            RandomListNode newNode = new RandomListNode(cur.label);
            RandomListNode nextNode = cur.next;
            cur.next = newNode;
            newNode.next = nextNode;
            cur = nextNode;
        }
        //再根据原来的结点，构造新结点的random
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
            cur1.next =  pHead;
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
