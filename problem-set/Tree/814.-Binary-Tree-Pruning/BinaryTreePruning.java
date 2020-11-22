/**
 * @Title:
 * @Author: FFYzz
 * @Mail: cryptochen95 at gmail dot com
 * @Date: 2020/11/22
 */
public class BinaryTreePruning {

    public TreeNode pruneTree(TreeNode root) {
        TreeNode res = root;
        boolean rootValue = isZeroTree(root);
        if (!rootValue) {
            res = null;
        }
        return res;
    }

    public boolean isZeroTree(TreeNode root) {
        if (root.left == null && root.right == null && root.val == 0) {
            return true;
        }
        if (root.left == null && root.right == null && root.val == 1) {
            return false;
        }
        boolean leftZeroTree = true;
        if (root.left != null) {
            leftZeroTree = isZeroTree(root.left);
        }
        if (leftZeroTree) {
            root.left = null;
        }
        boolean rightZeroTree = true;
        if (root.right != null) {
            rightZeroTree = isZeroTree(root.right);
        }
        if (rightZeroTree) {
            root.right = null;
        }
        return root.val == 0 && leftZeroTree == true && rightZeroTree == true;
    }

    public static void main(String[] args) {
        //[1,null,0,0,1]
        TreeNode n1 = new TreeNode(1);
        TreeNode n3 = new TreeNode(0);
        TreeNode n4 = new TreeNode(0);
        TreeNode n5 = new TreeNode(1);
        n1.left = null;
        n1.right = n3;
        n3.left = n4;
        n3.right = n5;
        new BinaryTreePruning().pruneTree(n1);


    }

}
