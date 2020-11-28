import java.util.Deque;
import java.util.LinkedList;

/**
 * @Title:
 * @Author: FFYzz
 * @Mail: cryptochen95 at gmail dot com
 * @Date: 2020/11/28
 */
public class SubtreeofAnotherTree {

    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null && t == null) {
            return true;
        }
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(s);
        while (!stack.isEmpty()) {
            TreeNode n = stack.pop();
            if (n.right != null) {
                stack.push(n.right);
            }
            if (n.left != null) {
                stack.push(n.left);
            }
            boolean midRes = testSubTree(n, t);
            if (midRes) {
                return true;
            }
        }
        return false;
    }

    public boolean testSubTree(TreeNode s, TreeNode t) {
        if ((s == null && t == null)) {
            return true;
        }
        if ((s == null && t != null) || (s != null && t == null) || s.val != t.val) {
            return false;
        }
        return testSubTree(s.left, t.left) && testSubTree(s.right, t.right);
    }

}

//[3,4,5,1,2]
//[4,1,2]

//[3,4,5,1,2,null,null,0]
//[4,1,2]

//[3,4,5,1,2]
//[4,1,2,1]