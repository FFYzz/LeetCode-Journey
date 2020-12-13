import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Title:
 * @Author: FFYzz
 * @Mail: cryptochen95 at gmail dot com
 * @Date: 2020/12/13
 */
public class DeleteNodesAndReturnForest {

    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        List<TreeNode> res = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        for (int deleted : to_delete) {
            set.add(deleted);
        }
        postOrder(root, set, res, null, false);
        if (!set.contains(root.val)) {
            res.add(root);
        }
        return res;
    }

    private void postOrder(TreeNode root, Set<Integer> deleted, List<TreeNode> res, TreeNode parent, boolean leftChild) {
        if (root == null) {
            return;
        }
        postOrder(root.left, deleted, res, root, true);
        postOrder(root.right, deleted, res, root, false);
        if (deleted.contains(root.val)) {
            if (root.left != null) {
                res.add(root.left);
            }
            if (root.right != null) {
                res.add(root.right);
            }
            if (parent != null) {
                if (leftChild) {
                    parent.left = null;
                } else {
                    parent.right = null;
                }
            }
            root.left = null;
            root.right = null;
        }
    }

}
