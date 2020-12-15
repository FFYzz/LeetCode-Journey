/**
 * @Title:
 * @Author:
 * @Mail: cryptochen95 at gmail dot com
 * @Date: 2020/12/15
 */
public class FlipEquivalentBinaryTrees {
    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        }
        if ((root1 == null || root2 == null) || (root1.val != root2.val)) {
            return false;
        }
        return flipEquivRec(root1, root2);
    }

    public boolean flipEquivRec(TreeNode root1Parent, TreeNode root2Parent) {
        if (root1Parent == null && root2Parent == null) {
            return true;
        }
        if (!isEqual(root1Parent.left, root2Parent.left)) {
            swapChild(root1Parent);
        }
        boolean res = isEqual(root1Parent.left, root2Parent.left);
        res = res && isEqual(root1Parent.right, root2Parent.right);
        if (!res) {
            return false;
        }
        return flipEquivRec(root1Parent.left, root2Parent.left) && flipEquiv(root1Parent.right, root2Parent.right);
    }

    public void swapChild(TreeNode parent) {
        TreeNode leftChild = parent.left;
        parent.left = parent.right;
        parent.right = leftChild;
    }

    public boolean isEqual(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) {
            return true;
        }
        if ((node1 != null && node2 == null) ||
                (node1 == null && node2 != null)) {
            return false;
        }
        return node1.val == node2.val;
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);
        TreeNode n7 = new TreeNode(7);
        TreeNode n8 = new TreeNode(8);
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.left = n6;
        n5.left = n7;
        n5.right = n8;

        TreeNode m1 = new TreeNode(1);
        TreeNode m2 = new TreeNode(2);
        TreeNode m3 = new TreeNode(3);
        TreeNode m4 = new TreeNode(4);
        TreeNode m5 = new TreeNode(5);
        TreeNode m6 = new TreeNode(6);
        TreeNode m7 = new TreeNode(7);
        TreeNode m8 = new TreeNode(8);
        m1.left = m3;
        m1.right = m2;
        m3.right = m6;
        m2.left = m4;
        m2.right = m5;
        m5.left = m8;
        m5.right = m7;
        new FlipEquivalentBinaryTrees().flipEquiv(n1, m1);

    }


}
