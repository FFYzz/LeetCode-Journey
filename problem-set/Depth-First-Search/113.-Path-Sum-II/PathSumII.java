import javax.print.DocFlavor;
import java.util.ArrayList;
import java.util.List;

/**
 * @Title:
 * @Author: FFYzz
 * @Mail: cryptochen95 at gmail dot com
 * @Date: 2020/10/24
 */
public class PathSumII {

    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root == null) {
            return res;
        }
        dfs(root, sum, new ArrayList<>());
        return res;
    }

    public void dfs(TreeNode currNode, int leftSum, List<Integer> currList) {
        List<Integer> newList = new ArrayList<>(currList);
        if (isLeaf(currNode) && currNode.val == leftSum) {
            newList.add(currNode.val);
            res.add(newList);
            return;
        }
        newList.add(currNode.val);
        if (currNode.left != null) {
            dfs(currNode.left, leftSum - currNode.val, newList);
        }
        if (currNode.right != null) {
            dfs(currNode.right, leftSum - currNode.val, newList);
        }
    }

    public boolean isLeaf(TreeNode node) {
        return node.left == null && node.right == null;
    }



}
