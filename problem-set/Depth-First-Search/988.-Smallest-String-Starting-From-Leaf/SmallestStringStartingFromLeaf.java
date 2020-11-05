/**
 * @Title:
 * @Author: FFYzz
 * @Mail: cryptochen95 at gmail dot com
 * @Date: 2020/11/5
 */
public class SmallestStringStartingFromLeaf {

    private String ans = "~";

    public String smallestFromLeaf(TreeNode root) {
        return dfs(root, "");
    }

    private String dfs(TreeNode root, String inStr) {
        if (root == null) {
            return inStr;
        }
        inStr = (char) (root.val + 'a') + inStr;
        // 到叶子节点了就比较
        if (root.left == null && root.right == null && ans.compareTo(inStr) > 0) {
            ans = inStr;
        }
        dfs(root.left, inStr);
        dfs(root.right, inStr);
        return ans;
    }

}
