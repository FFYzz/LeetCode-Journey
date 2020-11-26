/**
 * @Title:
 * @Author: FFYzz
 * @Mail: cryptochen95 at gmail dot com
 * @Date: 2020/11/27
 */
public class SumofLeftLeaves {

    private int sum = 0;

    public int sumOfLeftLeaves(TreeNode root) {
        preOrder(root, false);
        return sum;
    }

    public void preOrder(TreeNode node, boolean leftDirection) {
        if (node == null) {
            return;
        }
        if (node.left == null && node.right == null && leftDirection) {
            sum += node.val;
        }
        preOrder(node.left, true);
        preOrder(node.right, false);
    }

}
