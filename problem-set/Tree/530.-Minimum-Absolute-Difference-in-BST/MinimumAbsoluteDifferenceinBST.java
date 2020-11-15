import java.util.Deque;
import java.util.LinkedList;

/**
 * @Title:
 * @Author: FFYzz
 * @Mail: cryptochen95 at gmail dot com
 * @Date: 2020/11/16
 */
public class MinimumAbsoluteDifferenceinBST {

    int min = Integer.MAX_VALUE;
    Deque<Integer> stack = new LinkedList<>();

    public int getMinimumDifference(TreeNode root) {
        inOrderTraverse(root);
        return min;
    }

    public void inOrderTraverse(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrderTraverse(root.left);
        if (!stack.isEmpty()) {
            min = Math.min(min, root.val - stack.pop());
            stack.push(root.val);
        } else {
            stack.push(root.val);
        }
        inOrderTraverse(root.right);
    }

}
