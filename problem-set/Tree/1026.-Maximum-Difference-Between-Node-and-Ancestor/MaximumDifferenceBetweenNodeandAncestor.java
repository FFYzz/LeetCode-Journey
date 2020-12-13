/**
 * @Title:
 * @Author: FFYzz
 * @Mail: cryptochen95 at gmail dot com
 * @Date: 2020/12/13
 */
public class MaximumDifferenceBetweenNodeandAncestor {

    public int maxAncestorDiff(TreeNode root) {
        return dfs(root, root.val, root.val);
    }

    private int dfs(TreeNode root, int maxValue, int minValue) {
        if (root == null) {
            return maxValue - minValue;
        }
        maxValue = Math.max(root.val, maxValue);
        minValue = Math.min(root.val, minValue);
        return Math.max(dfs(root.left, maxValue, minValue), dfs(root.right, maxValue, minValue));
    }


}
