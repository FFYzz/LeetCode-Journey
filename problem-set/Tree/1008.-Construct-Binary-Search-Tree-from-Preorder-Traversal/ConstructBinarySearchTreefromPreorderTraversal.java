import java.util.Arrays;

/**
 * @Title: 1008. Construct Binary Search Tree from Preorder Traversal
 * @Author: FFYzz
 * @Mail: cryptochen95 at gmail dot com
 * @Date: 2020/4/20
 */
public class ConstructBinarySearchTreefromPreorderTraversal {

    public TreeNode bstFromPreorder(int[] preorder) {
        TreeNode root = new TreeNode(preorder[0]);
        helper(root, Arrays.copyOfRange(preorder, 1, preorder.length));
        return root;
    }

    public void helper(TreeNode pre, int[] sequence) {
        if (sequence == null || sequence.length == 0) {
            return;
        }
        int moreIndex = sequence.length;
        int lessIndex = -1;
        for (int i = 0; i < sequence.length; ++i) {
            if (sequence[i] < pre.val) {
                lessIndex = i;
                break;
            }
        }
        for (int i = 0; i < sequence.length; ++i) {
            if (sequence[i] > pre.val) {
                moreIndex = i;
                break;
            }
        }
        if (lessIndex != -1) {
            TreeNode node = new TreeNode(sequence[lessIndex]);
            pre.left = node;
            helper(node, Arrays.copyOfRange(sequence, lessIndex + 1, moreIndex));
        }
        if (moreIndex != sequence.length) {
            TreeNode node = new TreeNode(sequence[moreIndex]);
            pre.right = node;
            helper(node, Arrays.copyOfRange(sequence, moreIndex + 1, sequence.length));
        }
    }


    /**
     * concise solution
     */

    int i = 0;

    public TreeNode bstFromPreorder2(int[] A) {
        return bstFromPreorder(A, Integer.MAX_VALUE);
    }

    public TreeNode bstFromPreorder(int[] A, int bound) {
        if (i == A.length || A[i] > bound) return null;
        TreeNode root = new TreeNode(A[i++]);
        root.left = bstFromPreorder(A, root.val);
        root.right = bstFromPreorder(A, bound);
        return root;
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

