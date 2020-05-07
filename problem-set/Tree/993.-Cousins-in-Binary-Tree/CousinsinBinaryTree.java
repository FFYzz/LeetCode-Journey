import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @Title: 993. Cousins in Binary Tree
 * @Author: FFYzz
 * @Mail: cryptochen95 at gmail dot com
 * @Date: 2020/5/7
 */
public class CousinsinBinaryTree {

    public boolean isCousins(TreeNode root, int x, int y) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        HashMap<Integer, TreeNode> map = new HashMap<>();
        map.put(root.val, null);
        while (!queue.isEmpty()) {
            int queueSize = queue.size();
            for (int i = 0; i < queueSize; ++i) {
                TreeNode node = queue.poll();
                map.remove(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                    map.put(node.left.val, node);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                    map.put(node.right.val, node);
                }
            }
            if (map.containsKey(x) && map.containsKey(y) && (map.get(x) != map.get(y))) {
                return true;
            }
        }
        return false;
    }

}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
