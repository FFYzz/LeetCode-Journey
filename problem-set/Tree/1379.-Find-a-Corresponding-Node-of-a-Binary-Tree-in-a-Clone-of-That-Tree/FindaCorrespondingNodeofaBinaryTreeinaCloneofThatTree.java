/**
 * @Title: 1379. Find a Corresponding Node of a Binary Tree in a Clone of That Tree
 * @Author: FFYzz
 * @Mail: cryptochen95@gmail.com
 * @Date: 2020/4/2
 */
public class FindaCorrespondingNodeofaBinaryTreeinaCloneofThatTree {

    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        if (original == null || original == target) {
            return cloned;
        }
        TreeNode node = getTargetCopy(original.left, cloned.left, target);
        if (node != null) {
            return node;
        }
        return getTargetCopy(original.right, cloned.right, target);
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

