import java.util.LinkedList;

/**
 * @Title: 958. Check Completeness of a Binary Tree
 * @Author: FFYzz
 * @Mail: cryptochen95@gmail.com
 * @Date: 2020/3/14
 */
public class CheckCompletenessofaBinaryTree {

    public boolean isCompleteTree(TreeNode root) {
        if (root == null) {
            return true;
        }
        LinkedList<TreeNode> linkedList = new LinkedList<>();
        linkedList.offer(root);
        while (linkedList.peek() != null) {
            TreeNode curNode = linkedList.poll();
            linkedList.offer(curNode.left);
            linkedList.offer(curNode.right);
        }
        while (!linkedList.isEmpty() && linkedList.peek() == null) {
            linkedList.poll();
        }
        return linkedList.isEmpty();
    }

}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
