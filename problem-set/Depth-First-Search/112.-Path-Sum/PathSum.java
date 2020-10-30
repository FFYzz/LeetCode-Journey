/**
 * @Title:
 * @Author: FFYzz
 * @Mail: cryptochen95 at gmail dot com
 * @Date: 2020/10/24
 */
public class PathSum {

    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        if (isLeaf(root) && sum == root.val) {
            return true;
        }
        if (isLeaf(root) && sum != root.val) {
            return false;
        }
        boolean res = false;
        if (root.left != null) {
            res = res || hasPathSum(root.left, sum - root.val);
        }
        if (root.right != null) {
            res = res || hasPathSum(root.right, sum - root.val);
        }
        return res;
    }

    public boolean isLeaf(TreeNode node) {
        return node.left == null && node.right == null;
    }

    /**
     * mostVote
     *
     * @param root
     * @param sum
     * @return
     */
    public boolean hasPathSumP(TreeNode root, int sum) {
        if (root == null) return false;

        if (root.left == null && root.right == null && sum - root.val == 0) return true;

        return hasPathSumP(root.left, sum - root.val) || hasPathSumP(root.right, sum - root.val);
    }


}
