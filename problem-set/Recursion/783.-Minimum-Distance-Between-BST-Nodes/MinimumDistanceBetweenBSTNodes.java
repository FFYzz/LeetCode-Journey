/**
 * @Title:
 * @Author: FFYzz
 * @Mail: cryptochen95@gmail.com
 * @Date: 2020/3/11
 */
public class MinimumDistanceBetweenBSTNodes {

    private Integer pre = null;
    private Integer currDiff = Integer.MAX_VALUE;

    public int minDiffInBST(TreeNode root) {

        if (root.left != null) {
            minDiffInBST(root.left);
        }
        // 说明是排好序后的第一个元素
        if (pre != null) {
            currDiff = Math.min(currDiff, root.val - pre);
        }
        pre = root.val;
        if (root.right != null) {
            minDiffInBST(root.right);
        }
        return currDiff;

    }

    public void inoRDER(TreeNode node) {
        if (node == null) {
            return;
        }
        inoRDER(node.left);
        //do something
        inoRDER(node.right);
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
