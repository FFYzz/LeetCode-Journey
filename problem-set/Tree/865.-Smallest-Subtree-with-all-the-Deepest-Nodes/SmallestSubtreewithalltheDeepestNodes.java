/**
 * @Title:
 * @Author: FFYzz
 * @Mail: cryptochen95 at gmail dot com
 * @Date: 2020/12/15
 */
public class SmallestSubtreewithalltheDeepestNodes {
    private TreeNode res;
    private int maxLevel;

    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        dfs(root, 0);
        return res;
    }

    private int dfs(TreeNode root, int level) {
        if (root == null) {
            return level;
        }
        int leftLevel = dfs(root.left, level + 1);
        int rightLevel = dfs(root.right, level + 1);
        int currentLevel = Math.max(leftLevel, rightLevel);
        maxLevel = Math.max(maxLevel, currentLevel);
        if (leftLevel == rightLevel && leftLevel == maxLevel) {
            res = root;
        }
        return currentLevel;
    }

}
