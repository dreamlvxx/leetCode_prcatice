package jk;

import java.util.HashSet;

/**
 * 判断链表环的一系列问题
 */
public class JK06Code02 {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    /**
     * 判断是否有环
     *
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        if (head == null) return false;
        ListNode walker = head;
        ListNode runner = head;
        while (runner.next != null && runner.next.next != null) {
            walker = walker.next;
            runner = runner.next.next;
            if (walker == runner) {//有环的话，终究会相遇
                return true;
            }
        }
        return false;
    }

    /**
     * 判断环的入口点
     * 通过遍历
     * @param pHead
     * @return
     */
    public ListNode entryNodeOfLoop(ListNode pHead) {
        HashSet<ListNode> hs = new HashSet<>();
        while (pHead != null) {
            if (!hs.add(pHead))//如果add失败，代表已经存在
                return pHead;
            pHead = pHead.next;
        }
        return null;
    }

    /**
     * 通过快慢指针 找到环入口
     * https://www.cnblogs.com/dancingrain/p/3405197.html
     * https://www.cnblogs.com/fankongkong/p/7007869.html
     * https://www.cnblogs.com/xiaodi914/p/5795096.html
     *
     * fast多走一圈环的情况
     * 当slow走x节点数的时候，fast走了x + n节点数，那么 2x == x + n  得到 x = n，说明slow走了一个环的距离 ，进一步得到相遇点到入口的距离，也就是起点到入口的距离。
     *
     * fast多走n圈环的情况
     * 备注：在MeetingNode方法中，当快慢指针（slow、fast）相遇时，slow指针肯定没有遍历完链表，而fast指针已经在环内循环了n（n>=1）圈。假设slow指针走了s步，则fast指针走了2s步。同时，fast指针的步数还等于s加上在环上多转的n圈，设环长为r，则满足如下关系表达式：
     * 2s = s + nr;
     * 所以可知：s = nr;
     * 假设链表的头节点到“环的尾节点“的长度为L（注意，L不一定是链表长度），环的入口节点与相遇点的距离为x，链表的头节点到环入口的距离为a，则满足如下关系表达式：
     * a + x = s = nr;
     * 可得：a + x = (n - 1)r + r = (n - 1)r + (L - a)
     * 进一步得：a = (n - 1)r + (L -a - x)
     * 结论：
     * <1> (L - a -x)为相遇点到环入口节点的距离，即从相遇点开始向前移动(L -a -x)步后，会再次到达环入口节点。
     * <2> 从链表的头节点到环入口节点的距离 ＝ (n - 1) * 环内循环 ＋ 相遇点到环入口点的距离。
     * <3> 于是从链表头与相遇点分别设一个指针，每次各走一步，两个指针必定相遇，且相遇第一点为环入口点。
     * @param head
     * @return
     */
    public ListNode entryNodeOfLoop1(ListNode head) {
        if (head == null) return null;
        ListNode walker = head;
        ListNode runner = head;
        while (runner.next != null && runner.next.next != null) {
            walker = walker.next;
            runner = runner.next.next;
            if (walker == runner) {
                //=================================================
                runner = head;
                while (runner != walker){
                    walker = walker.next;
                    runner = runner.next;
                }
                return runner;
                //=================================================

            }
        }
        return null;
    }

    /**
     * 判断环中的节点个数
     * 再跑一圈就行了
     * @param head
     * @return
     */
    public int numberOfLoopForNode(ListNode head){
        if (head == null) return 0;
        ListNode walker = head;
        ListNode runner = head;
        while (runner.next != null && runner.next.next != null){
            runner = runner.next.next;
            walker = walker.next;
            if (runner == walker){
                int res = 1;
                ListNode temp = walker;
                walker = walker.next;
                while (walker != temp){
                    walker = walker.next;
                    ++ res;
                }
                return res;
            }
        }
        return 0;
    }
}
