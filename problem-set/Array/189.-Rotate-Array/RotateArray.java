/**
 * @Title: 189. Rotate Array
 * @Author: FFYzz
 * @Mail: cryptochen95 at gmail dot com
 * @Date: 2020/6/7
 */
public class RotateArray {

    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        swap(nums, 0, nums.length - k - 1);
        swap(nums, nums.length - k, nums.length - 1);
        swap(nums, 0, nums.length - 1);
    }

    public void swap(int[] arr, int start, int end) {
        if (end >= arr.length) {
            return;
        }
        while (start < end) {
            int temp = arr[start];
            arr[start++] = arr[end];
            arr[end--] = temp;
        }
    }

}
