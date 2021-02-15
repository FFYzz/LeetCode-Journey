/**
 * @Title:
 * @Author: FFYzz
 * @Mail: cryptochen95 at gmail dot com
 * @Date: 2021/2/15
 * @Description:
 */
public class ReverseNodesinkGroup {

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        int count = 0;
        ListNode worker = dummy.next;
        ListNode pre = dummy;
        while (worker != null) {
            ++count;
            if (count == k) {
                // worker 就是 oldEndNode
                ListNode oldStartNode = pre.next;
                ListNode oldEndNodeNext = worker.next;
                reverse(pre, oldEndNodeNext);
                pre.next = worker;
                oldStartNode.next = oldEndNodeNext;
                worker = oldStartNode;
                pre = worker;
                count = 0;
            }
            worker = worker.next;
        }
        return dummy.next;
    }

    /**
     * pre.next 到 next 的前驱节点需要 reverse
     *
     * @param pre
     * @param next
     */
    public void reverse(ListNode pre, ListNode next) {
        ListNode cur = pre.next;
        while (cur != next) {
            ListNode curNext = cur.next;
            cur.next = pre;
            pre = cur;
            cur = curNext;
        }
    }

}
