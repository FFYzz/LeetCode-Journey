/**
 * @Title:
 * @Author: FFYzz
 * @Mail: cryptochen95 at gmail dot com
 * @Date: 2020/11/26
 */
public class BinaryTreeTilt {

    private int sum = 0;

    public int findTilt(TreeNode root) {
        if (root == null) {
            return sum;
        }
        getTilt(root);
        return sum;
    }

    public int getTilt(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int val = root.val;
        int left = getTilt(root.left);
        int right = getTilt(root.right);
        sum += Math.abs(left - right);
        return val + left + right;
    }

}


