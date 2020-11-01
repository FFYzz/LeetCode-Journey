/**
 * @Title:
 * @Author: FFYzz
 * @Mail: cryptochen95 at gmail dot com
 * @Date: 2020/10/31
 */
public class ConvertSortedArraytoBinarySearchTree {

    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) {
            return null;
        }
        int left = 0, right = nums.length - 1;
        int mid = left + (right - left) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = half(nums, left, mid - 1);
        root.right = half(nums, mid + 1, right);
        return root;
    }

    private TreeNode half(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        int mid = left + (right - left) / 2;
        TreeNode cur = new TreeNode(nums[mid]);
        cur.left = half(nums, left, mid - 1);
        cur.right = half(nums, mid + 1, right);
        return cur;
    }

}
