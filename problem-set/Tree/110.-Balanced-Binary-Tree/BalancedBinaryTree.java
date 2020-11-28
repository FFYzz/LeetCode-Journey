/**
 * @Title:
 * @Author: FFYzz
 * @Mail: cryptochen95 at gmail dot com
 * @Date: 2020/11/29
 */
public class BalancedBinaryTree {

    boolean globalRes = true;

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        int left = height(root.left);
        int right = height(root.right);
        return globalRes && Math.abs(left - right) <= 1;
    }

    public int height(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        if (Math.abs(leftHeight - rightHeight) > 1) {
            globalRes = false;
        }
        return 1 + Math.max(leftHeight, rightHeight);
    }

}
