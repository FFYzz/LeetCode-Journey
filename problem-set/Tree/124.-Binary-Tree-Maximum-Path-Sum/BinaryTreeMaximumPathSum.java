/**
 * @Title: 124. Binary Tree Maximum Path Sum
 * @Author: FFYzz
 * @Mail: cryptochen95 at gmail dot com
 * @Date: 2020/4/29
 */
public class BinaryTreeMaximumPathSum {
    private int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        maxSub(root);
        return max;
    }

    public int maxSub(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = Math.max(0, maxSub(node.left));
        int right = Math.max(0, maxSub(node.right));
        max = Math.max(left + right + node.val, max);
        return Math.max(left, right) + node.val;
    }

}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
