import java.util.ArrayList;
import java.util.List;

/**
 * @Title: 1038. Binary Search Tree to Greater Sum Tree
 * @Author: FFYzz
 * @Mail: cryptochen95 at gmail dot com
 * @Date: 2020/4/13
 */
public class BinarySearchTreetoGreaterSumTree {

    List<Integer> list = new ArrayList<>();
    private Integer sum = 0;

    public TreeNode bstToGst(TreeNode root) {
        midTraversal(root, list);
        for (int num : list) {
            sum += num;
        }
        midTraversalCalculate(root);
        return root;
    }

    public void midTraversal(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }
        midTraversal(node.left, list);
        list.add(node.val);
        midTraversal(node.right, list);
    }

    public void midTraversalCalculate(TreeNode node) {
        if (node == null) {
            return;
        }
        midTraversalCalculate(node.left);
        int ge = sum;
        for (int i = 0; ; ++i) {
            if (list.get(i) == node.val) {
                break;
            }
            ge -= list.get(i);
        }
        node.val = ge;
        midTraversalCalculate(node.right);
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
