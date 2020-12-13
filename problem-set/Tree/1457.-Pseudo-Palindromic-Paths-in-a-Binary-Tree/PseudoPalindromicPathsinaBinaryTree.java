import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Title:
 * @Author: FFYzz
 * @Mail: cryptochen95 at gmail dot com
 * @Date: 2020/12/13
 */
public class PseudoPalindromicPathsinaBinaryTree {

    private int res = 0;

    public int pseudoPalindromicPaths(TreeNode root) {
        dfs(root, new ArrayList<TreeNode>());
        return res;
    }

    private void dfs(TreeNode root, List<TreeNode> currentList) {
        currentList.add(root);
        if (root.left == null && root.right == null) {
            if (isPalindromic(currentList)) {
                ++res;
            }
            return;
        }
        if (root.left != null) {
            List<TreeNode> midList = new ArrayList<>(currentList);
            dfs(root.left, midList);
        }
        if (root.right != null) {
            List<TreeNode> midList = new ArrayList<>(currentList);
            dfs(root.right, midList);
        }
    }


    public boolean isPalindromic(List<TreeNode> list) {
        System.out.println(Arrays.toString(list.toArray()));
        int[] countArray = new int[10];
        for (TreeNode node : list) {
            countArray[node.val]++;
        }
        int countOfOddNumeber = 0;
        for (int count : countArray) {
            if ((count & 1) == 1) {
                countOfOddNumeber++;
            }
        }
        return countOfOddNumeber <= 1;
    }

}
