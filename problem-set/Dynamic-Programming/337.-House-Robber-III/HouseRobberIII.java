import java.util.HashMap;
import java.util.Map;

/**
 * @Title:
 * @Author: FFYzz
 * @Mail: cryptochen95 at gmail dot com
 * @Date: 2021/1/5
 */
public class HouseRobberIII {

    public int rob(TreeNode root) {
        return rob1(root, new HashMap<>());
    }

    public int rob1(TreeNode root, Map<TreeNode, Integer> map) {
        if (root == null) {
            return 0;
        }
        if (map.containsKey(root)) {
            return map.get(root);
        }
        int val = 0;
        if (root.left != null) {
            val += (rob1(root.left.left, map) + rob1(root.left.right, map));
        }
        if (root.right != null) {
            val += (rob1(root.right.right, map) + rob1(root.right.left, map));
        }
        val = Math.max(root.val + val, rob1(root.left, map) + rob1(root.right, map));
        map.put(root, val);
        return val;
    }

}
