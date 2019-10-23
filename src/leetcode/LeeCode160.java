package leetcode;

import java.util.HashMap;
import java.util.Stack;

/**
 * If the two linked lists have no intersection at all, return null.
 * The linked lists must retain their original structure after the function returns.
 * You may assume there are no cycles anywhere in the entire linked structure.
 * Your code should preferably run in O(n) time and use only O(1) memory.
 */
public class LeeCode160 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    //全部添加一次headA，再添加headB，重复添加的就是那个结点
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        HashMap<ListNode,Integer> map = new HashMap<>();
        if (headA == null  || headB == null)return null;
        while (headA != null ){
            map.put(headA,map.getOrDefault(headA,0) + 1);
            headA = headA.next;
        }

        while (headB != null){
            map.put(headB,map.getOrDefault(headB,0) + 1);
            if (map.get(headB) > 1){
                return headB;
            }
            headB = headB.next;
        }

        return null;
    }


    // perfect coding
    public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        //boundary check
        if(headA == null || headB == null) return null;

        ListNode a = headA;
        ListNode b = headB;

        //这里通过交换引用，第一遍对齐两个链表，第二遍进行比对。
        while(a != b){
            //for the end of first iteration, we just reset the pointer to the head of another linkedlist
            a = a == null? headB : a.next;
            b = b == null? headA : b.next;
        }
        return a;
    }

}
