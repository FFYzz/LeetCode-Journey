import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @Title:
 * @Author: FFYzz
 * @Mail: cryptochen95 at gmail dot com
 * @Date: 2020/10/22
 */
public class BinaryTreeZigzagLevelOrderTraversal {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        boolean direction = true;
        Deque<TreeNode> queue = new LinkedList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty() || !stack.isEmpty()) {
            List<Integer> midList = new ArrayList<>();
            int queueSize = queue.size();
            int stackSize = stack.size();
            for (int i = 0; i < (direction ? queueSize : stackSize); ++i) {
                TreeNode curr = null;
                if (direction) {
                    curr = queue.poll();
                    if (curr.left != null) {
                        stack.push(curr.left);
                    }
                    if (curr.right != null) {
                        stack.push(curr.right);
                    }
                } else {
                    curr = stack.pop();
                    if (curr.right != null) {
                        queue.addFirst(curr.right);
                    }
                    if (curr.left != null) {
                        queue.addFirst(curr.left);
                    }
                }
                midList.add(curr.val);
            }
            direction = !direction;
            res.add(midList);
        }
        return res;
    }

}
