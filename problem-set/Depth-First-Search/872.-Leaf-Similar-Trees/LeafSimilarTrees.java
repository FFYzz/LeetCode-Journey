import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @Title:
 * @Author: FFYzz
 * @Mail: cryptochen95 at gmail dot com
 * @Date: 2020/10/31
 */
public class LeafSimilarTrees {

    public boolean leafSimilar2(TreeNode root1, TreeNode root2) {
        List<TreeNode> tree1List = new ArrayList<>();
        List<TreeNode> tree2List = new ArrayList<>();
        getPreOrderTraverse(root1, tree1List);
        getPreOrderTraverse(root2, tree2List);
        if (tree1List.size() != tree2List.size()) {
            return false;
        }
        for (int i = 0; i < tree1List.size(); ++i) {
            if (tree1List.get(i).val != tree2List.get(i).val) {
                return false;
            }
        }
        return true;
    }

    public void getPreOrderTraverse(TreeNode root, List<TreeNode> list) {
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            if (cur.left == null && cur.right == null) {
                list.add(cur);
            } else {
                if (cur.right != null) {
                    stack.push(cur.right);
                }
                if (cur.left != null) {
                    stack.push(cur.left);
                }
            }
        }
    }

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        Deque<TreeNode> stack1 = new LinkedList<>();
        Deque<TreeNode> stack2 = new LinkedList<>();
        stack1.push(root1);
        stack2.push(root2);
        while (!stack1.isEmpty() && !stack2.isEmpty()) {
            if (dfs(stack1) != dfs(stack2)) {
                return false;
            }
        }
        return stack1.isEmpty() && stack2.isEmpty();
    }

    private int dfs(Deque<TreeNode> stack) {
        while (true) {
            TreeNode cur = stack.pop();
            if (cur.right != null) {
                stack.push(cur.right);
            }
            if (cur.left != null) {
                stack.push(cur.left);
            }
            if (cur.left == null && cur.right == null) {
                return cur.val;
            }
        }
    }
}


