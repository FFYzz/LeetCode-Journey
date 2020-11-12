import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Title:
 * @Author: FFYzz
 * @Mail: cryptochen95 at gmail dot com
 * @Date: 2020/11/12
 */
public class FindElements {

    Set<Integer> set = new HashSet<>();

    public FindElements(TreeNode root) {
        reConstruct(root, 0);
    }

    public boolean find(int target) {
        return set.contains(target);
    }

    public void reConstruct(TreeNode root, int val) {
        if (root == null) {
            return;
        }
        root.val = 0;
        int leftValue = val * 2 + 1;
        int rightValue = val * 2 + 2;
        set.add(val);
        reConstruct(root.left, leftValue);
        reConstruct(root.right, rightValue);
    }


}
