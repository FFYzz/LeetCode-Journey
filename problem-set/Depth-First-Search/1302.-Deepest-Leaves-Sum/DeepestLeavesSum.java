import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * @Title: 1302. Deepest Leaves Sum
 * @Author: FFYzz
 * @Mail: cryptochen95@gmail.com
 * @Date: 2020/4/4
 */
public class DeepestLeavesSum {


    /**
     * DFS
     *
     * @param root
     * @return
     */
    public int deepestLeavesSum(TreeNode root) {
        /**
         * Integer: maxDepth
         * Integer: value of current maxDepth
         */
        Map<Integer, Integer> map = new HashMap<>();
        findTheMaxDepth(root, 0, map);
        int max = Integer.MIN_VALUE;
        for (int key : map.keySet()) {
            if (key > max) {
                max = key;
            }
        }
        return map.get(max);
    }

    public void findTheMaxDepth(TreeNode node, int level, Map map) {
        if (node.left == null && node.right == null) {
            map.put(level, (Integer) map.getOrDefault(level, 0) + node.val);
            return;
        }
        if (node.left != null) findTheMaxDepth(node.left, level + 1, map);
        if (node.right != null) findTheMaxDepth(node.right, level + 1, map);
    }


    /**
     * level Traversal
     *
     * @param root
     * @return
     */
    public int deepestLeavesSum2(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int res = root.val;
        while (queue.size() != 0) {
            int queueLength = queue.size();
            res = 0;
            for (int i = 0; i < queueLength; ++i) {
                TreeNode node = queue.poll();
                res += node.val;
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }
        return res;
    }


}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

