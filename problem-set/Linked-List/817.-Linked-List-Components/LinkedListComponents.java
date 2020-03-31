import java.util.HashSet;

/**
 * @Title: 817. Linked List Components
 * @Author: FFYzz
 * @Mail: cryptochen95@gmail.com
 * @Date: 2020/3/31
 */
public class LinkedListComponents {

    public int numComponents(ListNode head, int[] G) {
        HashSet<Integer> set = new HashSet<>();
        for (int g : G) set.add(g);
        int count = 0;
        boolean match = false;
        while (head != null) {
            if (set.contains(head.val)) match = true;
            else if (match) {
                count++;
                match = false;
            }
            head = head.next;
        }
        if (match) count++;
        return count;
    }


}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

