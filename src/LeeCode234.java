import java.util.Stack;

/**
 *
 */
public class LeeCode234 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public boolean isPalindrome(ListNode head) {
        if (null == head)return true;
        ListNode slow = head,fast = head;
        while (fast !=null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        if (fast != null) { //奇数的时候再往后移动一个
            slow = slow.next;
        }

        slow = reverse(slow);
        fast = head;

        while (slow != null ){
            if (slow.val != fast.val){
                return false;
            }
            slow = slow.next;
            fast = fast.next;
        }
        return true;
    }

    private ListNode reverse(ListNode head){
        ListNode newNode = null;
        while (head != null){
            ListNode temp = head.next;//临时存一下
            head.next = newNode;//指针做逆转

            newNode = head;//后移
            head = temp;//后移
        }
        return newNode;
    }

}
