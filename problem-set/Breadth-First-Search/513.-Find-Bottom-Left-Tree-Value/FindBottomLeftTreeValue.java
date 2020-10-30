import java.util.LinkedList;
import java.util.Queue;

/**
 * @Title:
 * @Author: FFYzz
 * @Mail: cryptochen95 at gmail dot com
 * @Date: 2020/10/26
 */
public class FindBottomLeftTreeValue {

    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode targetNode = root;
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            targetNode = queue.element();
            for (int i = 0; i < size; ++i) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }
        return targetNode.val;
    }

}
