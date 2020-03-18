import java.util.ArrayList;
import java.util.List;

/**
 * @Title: 894. All Possible Full Binary Trees
 * @Author: FFYzz
 * @Mail: cryptochen95@gmail.com
 * @Date: 2020/3/18
 */
public class AllPossibleFullBinaryTrees {
    public List<TreeNode> allPossibleFBT(int N) {
        List<TreeNode> res = new ArrayList<>();
        if (N % 2 == 0) return res;
        if (N == 1) {
            res.add(new TreeNode(0));
            return res;
        }
        for (int leftNum = 1; leftNum < N - 1; leftNum += 2) {
            List<TreeNode> fLeft = allPossibleFBT(leftNum);
            List<TreeNode> fRight = allPossibleFBT(N - leftNum - 1);
            for (TreeNode leftTreeNode : fLeft) {
                for (TreeNode rightTreeNode : fRight) {
                    // 根节点
                    TreeNode treeNode = new TreeNode(0);
                    treeNode.left = leftTreeNode;
                    treeNode.right = rightTreeNode;
                    res.add(treeNode);
                }
            }
        }
        return res;
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

