import java.util.Arrays;

/**
 * @Title:
 * @Author: FFYzz
 * @Mail: cryptochen95 at gmail dot com
 * @Date: 2020/12/3
 */
public class ConstructBinaryTreefromPreorderandPostorderTraversal {

    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        if (pre.length == 0 || post.length == 0) {
            return null;
        }

        TreeNode root = new TreeNode(pre[0]);
        if (pre.length == 1) {
            return root;
        }
        int leftRootIndexInPostOrder = pre[1];
        for (int i = 0; i < post.length; ++i) {
            if (post[i] == pre[1]) {
                leftRootIndexInPostOrder = i;
                break;
            }
        }
        // 单叉树
        if (leftRootIndexInPostOrder == post.length - 2) {
            int[] leftNodes = Arrays.copyOfRange(pre, 1, pre.length);
            int[] rightNodes = Arrays.copyOfRange(post, 0, post.length - 1);
            root.left = constructFromPrePost(leftNodes, rightNodes);
        } else {
            int[] leftPreNodes = Arrays.copyOfRange(pre, 1, leftRootIndexInPostOrder + 1 + 1);
            int[] leftPostNodes = Arrays.copyOfRange(post, 0, leftRootIndexInPostOrder + 1);
            int[] rightPreNodes = Arrays.copyOfRange(pre, leftRootIndexInPostOrder + 1 + 1, pre.length);
            int[] rightPostNodes = Arrays.copyOfRange(post, leftRootIndexInPostOrder + 1, pre.length - 1);
            root.left = constructFromPrePost(leftPreNodes, leftPostNodes);
            root.right = constructFromPrePost(rightPreNodes, rightPostNodes);
        }
        return root;
    }

}
