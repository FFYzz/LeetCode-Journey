/**
 * @Title:
 * @Author: FFYzz
 * @Mail: cryptochen95 at gmail dot com
 * @Date: 2020/12/4
 */
public class CountGoodNodesinBinaryTree {

    private int res = 0;

    public int goodNodes(TreeNode root) {
        if (root == null) {
            return res;
        }
        dfs(root, Integer.MIN_VALUE);
        return res;
    }

    private void dfs(TreeNode root, int currentMax) {
        if (root == null) {
            return;
        }
        if (root.val >= currentMax) {
            ++res;
            currentMax = root.val;
        }
        dfs(root.left, currentMax);
        dfs(root.right, currentMax);
    }
}
