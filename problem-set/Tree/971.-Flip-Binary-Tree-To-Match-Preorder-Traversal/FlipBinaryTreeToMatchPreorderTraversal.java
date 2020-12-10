import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Title:
 * @Author: FFYzz
 * @Mail: cryptochen95 at gmail dot com
 * @Date: 2020/12/11
 */
public class FlipBinaryTreeToMatchPreorderTraversal {

    private List<Integer> res = new ArrayList<>();
    private int indexOfVoyage = 0;

    public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
        return dfs(root, voyage) ? res : Arrays.asList(-1);
    }

    private boolean dfs(TreeNode root, int[] voyage) {
        if (root == null) {
            return true;
        }
        if (root.val != voyage[indexOfVoyage++]) {
            return false;
        }
        if (root.left != null && root.left.val != voyage[indexOfVoyage]) {
            res.add(root.val);
            return dfs(root.right, voyage) && dfs(root.left, voyage);
        }
        return dfs(root.left, voyage) && dfs(root.right, voyage);
    }

}
