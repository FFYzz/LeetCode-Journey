/**
 * @Title: 237. Delete Node in a Linked List
 * @Author: FFYzz
 * @Mail: cryptochen95@gmail.com
 * @Date: 2020/3/13
 */
public class DeleteNodeinaLinkedList {

    /**
     * This is my stupid solution
     *
     * @param node
     */
    public void deleteNode(ListNode node) {
        ListNode preNode = null;
        ListNode curNode = node;
        ListNode nextNode = node.next;
        while (nextNode != null) {
            curNode.val = nextNode.val;
            preNode = curNode;
            curNode = nextNode;
            nextNode = nextNode.next;
        }
        preNode.next = null;
    }

    /**
     * This is a concise solution from Discuss
     *
     * @param node
     */
    public void deleteNode2(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

}


class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

