import java.util.ArrayList;
import java.util.List;

/**
 * @Title: 230. Kth Smallest Element in a BST
 * @Author: FFYzz
 * @Mail: cryptochen95 at gmail dot com
 * @Date: 2020/5/20
 */
public class KthSmallestElementinaBST {

    /**
     * 中序遍历解法
     *
     * @param root
     * @param k
     * @return
     */
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        traversal(root, list);
        return list.get(k);
    }

    public void traversal(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }
        traversal(node.left, list);
        list.add(node.val);
        traversal(node.right, list);
    }

    private int count = 0;
    private int res = -1;

    /**
     * 中序遍历，空间与时间都有提升
     *
     * @param root
     * @param k
     * @return
     */
    public int kthSmallest2(TreeNode root, int k) {
        count = k;
        traversal2(root);
        return res;
    }

    public void traversal2(TreeNode node) {
        if (node == null) {
            return;
        }
        traversal2(node.left);
        --count;
        if (count == 0) {
            res = node.val;
            return;
        }
        traversal2(node.right);
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

