/**
 * @Title:
 * @Author: FFYzz
 * @Mail: cryptochen95 at gmail dot com
 * @Date: 2020/11/4
 */
public class LowestCommonAncestorofDeepestLeaves {

    public TreeNode lcaDeepestLeaves(TreeNode root) {
        Pair pair = dfs(root, 0);
        return pair.node;
    }

    public Pair dfs(TreeNode node, int depth) {
        if (node == null) {
            return new Pair(null, depth);
        }
        Pair l = dfs(node.left, depth + 1);
        Pair r = dfs(node.right, depth + 1);
        if (l.depth == r.depth) {
            return new Pair(node, l.depth);
        } else {
            return l.depth > r.depth ? l : r;
        }
    }

    class Pair {
        TreeNode node;
        int depth;

        public Pair(TreeNode node, int depth) {
            this.node = node;
            this.depth = depth;
        }
    }

}
