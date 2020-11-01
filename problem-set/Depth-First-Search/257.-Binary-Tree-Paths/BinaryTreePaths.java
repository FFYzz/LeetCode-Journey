import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Title:
 * @Author: FFYzz
 * @Mail: cryptochen95 at gmail dot com
 * @Date: 2020/11/1
 */
public class BinaryTreePaths {

    List<String> res = new ArrayList<>();

    public List<String> binaryTreePaths(TreeNode root) {
        LinkedList<TreeNode> sequence = new LinkedList<>();
        if (root == null) {
            return res;
        }
        dfs(root, sequence);
        return res;
    }

    public void dfs(TreeNode treeNode, LinkedList<TreeNode> list) {
        if (treeNode == null) {
            return;
        } else {
            list.addLast(treeNode);
        }
        // find the leaf node
        if (treeNode.left == null && treeNode.right == null) {
            res.add(getSequence(list));
            list.removeLast();
            return;
        }
        // recursion
        if (treeNode.left != null) {
            dfs(treeNode.left, list);
        }
        if (treeNode.right != null) {
            dfs(treeNode.right, list);
        }
        list.removeLast();
    }

    public String getSequence(LinkedList<TreeNode> list) {
        int size = list.size();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; ++i) {
            sb.append(list.get(i).val);
            if (i != size - 1) {
                sb.append("->");
            }
        }
        return sb.toString();
    }

}
