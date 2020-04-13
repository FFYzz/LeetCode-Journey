/**
 * @Title: 701. Insert into a Binary Search Tree
 * @Author: FFYzz
 * @Mail: cryptochen95 at gmail dot com
 * @Date: 2020/4/13
 */
public class InsertintoaBinarySearchTree {

    public TreeNode insertIntoBST(TreeNode root, int val) {
        TreeNode node = root;
        TreeNode pre = node;
        while (node != null) {
            pre = node;
            if (val > node.val) {
                node = node.right;
            } else {
                node = node.left;
            }
        }
        TreeNode newNode = new TreeNode(val);
        if (pre.val > val) {
            pre.left = newNode;
        } else {
            pre.right = newNode;
        }
        return root;
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

