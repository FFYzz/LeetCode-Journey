/**
 * @Title:
 * @Author: FFYzz
 * @Mail: cryptochen95 at gmail dot com
 * @Date: 2020/11/20
 */
public class UnivaluedBinaryTree {

    public boolean isUnivalTree(TreeNode root) {
        return dfs(root, root.val);
    }

    private boolean dfs(TreeNode root, int val) {
        if (root.left == null && root.right == null) {
            return true;
        }
        boolean left = true;
        if (root.left != null) {
            left = root.left.val == val && dfs(root.left, val);
        }
        if (!left) {
            return false;
        }
        boolean right = true;
        if (root.right != null) {
            right = root.right.val == val && dfs(root.right, val);
        }
        return right;
    }


}
