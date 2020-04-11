/**
 * @Title: 543. Diameter of Binary Tree
 * @Author: FFYzz
 * @Mail: cryptochen95@gmail.com
 * @Date: 2020/4/11
 */
public class DiameterofBinaryTree {

    private int currentMax = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        helper(root);
        return currentMax;
    }

    public int helper(TreeNode currentNode) {
        int leftCount = 0;
        int rightCount = 0;
        if (currentNode.left != null) {
            leftCount = 1 + helper(currentNode.left);
        }
        if (currentNode.right != null) {
            rightCount = 1 + helper(currentNode.right);
        }
        currentMax = Math.max(currentMax, leftCount + rightCount);
        return Math.max(leftCount, rightCount);
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

//          1
//         / \
//        2   3
//       / \
//      4   5

