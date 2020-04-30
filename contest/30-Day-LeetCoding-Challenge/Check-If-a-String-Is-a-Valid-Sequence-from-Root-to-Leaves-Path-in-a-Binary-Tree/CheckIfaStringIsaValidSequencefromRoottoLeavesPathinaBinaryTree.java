/**
 * @Title: Check If a String Is a Valid Sequence from Root to Leaves Path in a Binary Tree
 * @Author: FFYzz
 * @Mail: cryptochen95 at gmail dot com
 * @Date: 2020/4/30
 */
public class CheckIfaStringIsaValidSequencefromRoottoLeavesPathinaBinaryTree {

    public boolean isValidSequence(TreeNode root, int[] arr) {
        if (root == null) {
            return arr.length == 0;
        }
        return isValidSequence(root, arr, 0);
    }

    public boolean isValidSequence(TreeNode node, int[] arr, int currentIndex) {
        if (currentIndex >= arr.length || node.val != arr[currentIndex]) {
            return false;
        }
        if (node.left == null && node.right == null) {
            return currentIndex == arr.length - 1;
        }
        boolean res = false;
        if (node.left != null) {
            res |= isValidSequence(node.left, arr, currentIndex + 1);
        }
        if (node.right != null) {
            res |= isValidSequence(node.right, arr, currentIndex + 1);
        }
        return res;
    }

    //[0,1,0,0,1,0,null,null,1,0,0]
    //[0,1,1]

    //[8,3,null,2,1,5,4]
    //[8]
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
