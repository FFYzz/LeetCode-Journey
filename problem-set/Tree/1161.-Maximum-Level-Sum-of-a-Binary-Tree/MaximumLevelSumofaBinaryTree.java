import java.util.LinkedList;
import java.util.Queue;

/**
 * @Title:
 * @Author: FFYzz
 * @Mail: cryptochen95 at gmail dot com
 * @Date: 2020/12/13
 */
public class MaximumLevelSumofaBinaryTree {

    public int maxLevelSum(TreeNode root) {
        int maxVal = Integer.MIN_VALUE;
        int maxLevel = 1;
        int level = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            ++level;
            int size = queue.size();
            int sum = 0;
            for (int i = 0; i < size; ++i) {
                TreeNode node = queue.poll();
                sum += node.val;
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            if (sum > maxVal) {
                maxVal = sum;
                maxLevel = level;
            }
        }
        return maxLevel;
    }

}
