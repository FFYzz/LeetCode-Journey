/**
 * @Title: 938. Range Sum of BST
 * @Author: FFYzz
 * @Mail: cryptochen95@gmail.com
 * @Date: 2020/3/10
 */
public class RangeSumofBST {

    public int rangeSumBST(TreeNode root, int L, int R) {
        if (root == null) {
            return 0;
        }
        int currentLevelValue = 0;
        if (root.val < L) {
            currentLevelValue = rangeSumBST(root.right, L, R);
        } else if (root.val > R) {
            currentLevelValue = rangeSumBST(root.left, L, R);
        } else {
            currentLevelValue = root.val + rangeSumBST(root.left, L, R) + rangeSumBST(root.right, L, R);
        }
        return currentLevelValue;
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

