package offer;

/**
 * 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 */
public class JZ25 {

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    public ListNode Merge(ListNode list1,ListNode list2) {
        if(list1 == null && list2 == null){
            return null;
        }
        if(list1 == null){
            return list2;
        }
        if(list2 == null){
            return list1;
        }
        if(list1.val > list2.val){
            list2.next = Merge(list2.next,list1);
            return list2;
        }else{
            list1.next = Merge(list1.next,list2);
            return list1;
        }
    }

    public ListNode Merge1(ListNode list1,ListNode list2){
        ListNode res = new ListNode(0);
        res.next = null;
        ListNode root = res;
        while (list1 != null && list2 != null){
            if (list1.val > list2.val){
                res.next = list2;
                res = list2;
                list2 = list2.next;
            }else{
                res.next = list1;
                res = list1;
                list1 = list1.next;
            }
        }
        if (list1 != null){
            res.next = list1;
        }
        if (list2 != null){
            res.next = list2;
        }
        return root.next;
    }
}
