import java.util.ArrayList;
import java.util.List;

/**
 * @Title:
 * @Author: FFYzz
 * @Mail: cryptochen95 at gmail dot com
 * @Date: 2020/11/20
 */
public class SumofRootToLeafBinaryNumbers {

    private int res = 0;

    public int sumRootToLeaf(TreeNode root) {
        List<Integer> currentStatus = new ArrayList<>();
        currentStatus.add(root.val);
        dfs(root, currentStatus);
        System.out.println(res);
        return res;
    }

    private void dfs(TreeNode root, List<Integer> currentStatus) {
        if (root.left == null && root.right == null) {
            int val = 0;
            for (int i = currentStatus.size() - 1; i >= 0; --i) {
                val += currentStatus.get(i) * Math.pow(2, currentStatus.size() - i - 1);
            }
            res += val;
            return;
        }
        if (root.left != null) {
            List<Integer> midList = new ArrayList<>(currentStatus);
            midList.add(root.left.val);
            dfs(root.left, midList);
        }
        if (root.right != null) {
            List<Integer> midList = new ArrayList<>(currentStatus);
            midList.add(root.right.val);
            dfs(root.right, midList);
        }
    }


    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(0);
        TreeNode n3 = new TreeNode(1);
        TreeNode n4 = new TreeNode(0);
        TreeNode n5 = new TreeNode(1);
        TreeNode n6 = new TreeNode(0);
        TreeNode n7 = new TreeNode(1);
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.left = n6;
        n3.right = n7;
        new SumofRootToLeafBinaryNumbers().sumRootToLeaf(n1);

    }


}
