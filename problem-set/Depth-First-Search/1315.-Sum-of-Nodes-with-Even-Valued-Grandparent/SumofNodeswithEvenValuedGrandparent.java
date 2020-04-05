/**
 * @Title: 1315. Sum of Nodes with Even-Valued Grandparent
 * @Author: FFYzz
 * @Mail: cryptochen95@gmail.com
 * @Date: 2020/4/5
 */
public class SumofNodeswithEvenValuedGrandparent {

    public int sumEvenGrandparent(TreeNode root) {
        int res = 0;
        if (root == null) {
            return res;
        } else {
            if ((root.val & 1) == 0) {
                res += getGrandsonValue(root);
            }
        }
        res += sumEvenGrandparent(root.left);
        res += sumEvenGrandparent(root.right);
        return res;
    }

    public int getGrandsonValue(TreeNode node) {
        int res = 0;
        if (node.left != null) {
            if (node.left.left != null) {
                res += node.left.left.val;
            }
            if (node.left.right != null) {
                res += node.left.right.val;
            }
        }
        if (node.right != null) {
            if (node.right.left != null) {
                res += node.right.left.val;
            }
            if (node.right.right != null) {
                res += node.right.right.val;
            }
        }
        return res;
    }

    public int sumEvenGrandparent2(TreeNode root) {
        return dfs(root, null, null);
    }

    public int dfs(TreeNode currentNode, TreeNode parentNode, TreeNode grandParentNode) {
        int res = 0;
        if (currentNode == null) {
            return res;
        }
        if (grandParentNode != null && ((grandParentNode.val & 1) == 0)) {
            res += currentNode.val;
        }
        return res + dfs(currentNode.left, currentNode, parentNode) + dfs(currentNode.right, currentNode, parentNode);
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

