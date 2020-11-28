import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Title:
 * @Author: FFYzz
 * @Mail: cryptochen95 at gmail dot com
 * @Date: 2020/11/29
 */
public class FindModeinBinarySearchTree {

    public int[] findMode(TreeNode root) {
        Map<Integer, Integer> map = new HashMap<>();
        preOrder(root, map);
        int maxCount = 0;
        List<Integer> res = new ArrayList<>();
        for (Map.Entry entry : map.entrySet()) {
            int count = (int) entry.getValue();
            if (count > maxCount) {
                maxCount = count;
                res.clear();
                res.add((Integer) entry.getKey());
            } else if (count == maxCount) {
                res.add((Integer) entry.getKey());
            }
        }
        return res.stream().mapToInt(Integer::intValue).toArray();
    }

    public void preOrder(TreeNode node, Map<Integer, Integer> map) {
        if (node == null) {
            return;
        }
        map.put(node.val, map.getOrDefault(node.val, 0) + 1);
        preOrder(node.left, map);
        preOrder(node.right, map);
    }


}
