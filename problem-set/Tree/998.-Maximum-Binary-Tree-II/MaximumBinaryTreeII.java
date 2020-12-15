/**
 * @Title:
 * @Author: FFYzz
 * @Mail: cryptochen95 at gmail dot com
 * @Date: 2020/12/15
 */
public class MaximumBinaryTreeII {

    public TreeNode insertIntoMaxTree(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        if (val > root.val) {
            TreeNode node = new TreeNode(val);
            node.left = root;
            return node;
        }
        insertNode(root, new TreeNode(val));
        return root;

    }

    private void insertNode(TreeNode root, TreeNode node) {
        if (root.right == null) {
            root.right = node;
            return;
        }
        if (root.right.val < node.val) {
            TreeNode rightCopy = root.right;
            root.right = node;
            node.left = rightCopy;
            return;
        } else {
            insertNode(root.right, node);
            return;
        }
    }

}
