/**
 * @Title: 654. Maximum Binary Tree
 * @Author: FFYzz
 * @Mail: cryptochen95 at gmail dot com
 * @Date: 2020/4/13
 */
public class MaximumBinaryTree {

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        int rootIndex = findMaxIndex(nums, 0, nums.length - 1);
        TreeNode root = new TreeNode(nums[rootIndex]);
        buildSubTree(root, nums, 0, rootIndex - 1, true);
        buildSubTree(root, nums, rootIndex + 1, nums.length - 1, false);
        return root;
    }

    public void buildSubTree(TreeNode node, int[] arr, int left, int right, boolean leftSide) {
        if (left > right) return;
        int maxIndex = findMaxIndex(arr, left, right);
        TreeNode newNode = new TreeNode(arr[maxIndex]);
        if (leftSide) {
            node.left = newNode;
        } else {
            node.right = newNode;
        }
        buildSubTree(newNode, arr, left, maxIndex - 1, true);
        buildSubTree(newNode, arr, maxIndex + 1, right, false);
    }

    public int findMaxIndex(int[] arr, int left, int right) {
        int maxIndex = left;
        for (int i = left; i <= right; ++i) {
            if (arr[i] > arr[maxIndex]) {
                maxIndex = i;
            }
        }
        return maxIndex;
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

