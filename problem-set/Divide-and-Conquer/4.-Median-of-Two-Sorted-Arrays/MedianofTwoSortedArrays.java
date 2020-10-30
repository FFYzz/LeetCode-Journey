
/**
 * @Title:
 * @Author: FFYzz
 * @Mail: cryptochen95 at gmail dot com
 * @Date: 2020/10/16
 */
public class MedianofTwoSortedArrays {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int midIndex = (nums1.length + nums2.length) / 2;
        int count = 0, pre = 0, cur = 0, index1 = 0, index2 = 0;
        while ((index1 < nums1.length || index2 < nums2.length) && count <= midIndex) {
            pre = cur;
            if (index1 >= nums1.length) {
                cur = nums2[index2];
                ++index2;
            } else if (index2 >= nums2.length) {
                cur = nums1[index1];
                ++index1;
            } else {
                if (nums1[index1] <= nums2[index2]) {
                    cur = nums1[index1];
                    ++index1;
                } else {
                    cur = nums2[index2];
                    ++index2;
                }
            }
            ++count;
        }
        if (((nums1.length + nums2.length) & 1) == 0) {
            return (cur + pre) / 2.0;
        } else {
            return cur;
        }
    }


    public static void main(String[] args) {
        new MedianofTwoSortedArrays().findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4});
    }

}
