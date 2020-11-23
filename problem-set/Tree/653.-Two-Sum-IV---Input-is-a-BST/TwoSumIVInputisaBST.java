import java.util.HashSet;
import java.util.Set;

/**
 * @Title:
 * @Author: FFYzz
 * @Mail: cryptochen95 at gmail dot com
 * @Date: 2020/11/24
 */
public class TwoSumIVInputisaBST {

    public boolean findTarget(TreeNode root, int k) {
        Set<Integer> set = new HashSet<>();
        return preOrder(root, set, k);
    }

    public boolean preOrder(TreeNode root, Set<Integer> set, int target) {
        if (root == null) {
            return false;
        }
        boolean res = set.contains(target - root.val);
        set.add(root.val);
        res = res || preOrder(root.left, set, target);
        res = res || preOrder(root.right, set, target);
        return res;
    }

}
