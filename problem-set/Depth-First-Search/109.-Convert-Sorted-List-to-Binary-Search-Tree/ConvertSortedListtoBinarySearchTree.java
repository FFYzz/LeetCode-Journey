/**
 * @Title:
 * @Author: FFYzz
 * @Mail: cryptochen95 at gmail dot com
 * @Date: 2020/11/1
 */
public class ConvertSortedListtoBinarySearchTree {

    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        return dfs(head, null);
    }

    public TreeNode dfs(ListNode start, ListNode end) {
        if (start == end) {
            return null;
        }
        ListNode mid = findTheMid(start, end);
        TreeNode cur = new TreeNode(mid.val);
        cur.left = dfs(start, mid);
        cur.right = dfs(mid.next, end);
        return cur;
    }

    public ListNode findTheMid(ListNode l, ListNode r) {
        ListNode dummy = new ListNode();
        dummy.next = l;
        ListNode mid = dummy, fast = dummy;
        while (fast != r && fast.next != r) {
            mid = mid.next;
            fast = fast.next.next;
        }
        return mid;
    }

}
