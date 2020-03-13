/**
 * @Title: 876. Middle of the Linked List
 * @Author: FFYzz
 * @Mail: cryptochen95@gmail.com
 * @Date: 2020/3/13
 */
public class MiddleoftheLinkedList {

    public ListNode middleNode(ListNode head) {
        ListNode node1 = head;
        ListNode node2 = head;
        while (node2 != null && node2.next != null) {
            node1 = node1.next;
            node2 = node2.next.next;
        }
        return node1;
    }
}


class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
