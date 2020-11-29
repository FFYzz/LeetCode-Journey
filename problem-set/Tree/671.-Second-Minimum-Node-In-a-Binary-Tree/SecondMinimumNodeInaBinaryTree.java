/**
 * @Title:
 * @Author: FFYzz
 * @Mail: cryptochen95 at gmail dot com
 * @Date: 2020/11/29
 */
public class SecondMinimumNodeInaBinaryTree {

    public int findSecondMinimumValue(TreeNode root) {
        if (root == null) {
            return -1;
        }
        if (root.left == null && root.right == null) {
            return -1;
        }
        int leftVal = root.left.val;
        int rightVal = root.right.val;
        if (root.val == leftVal) {
            leftVal = findSecondMinimumValue(root.left);
        }
        if (root.val == rightVal) {
            rightVal = findSecondMinimumValue(root.right);
        }
        if (leftVal != -1 && rightVal != -1) {
            return Math.min(leftVal, rightVal);
        }
        if (leftVal != -1) {
            return leftVal;
        }
        if (rightVal != -1) {
            return rightVal;
        }
        return -1;
    }

}
