/**
 * @Title: 852. Peak Index in a Mountain Array
 * @Author: FFYzz
 * @Mail: cryptochen95@gmail.com
 * @Date: 2020/3/30
 */
public class PeakIndexinaMountainArray {

    /**
     * brute force
     * BAD IDEA
     *
     * @param A
     * @return
     */
    public int peakIndexInMountainArray(int[] A) {
        for (int i = 1; i < A.length - 1; ++i) {
            if (A[i] > A[i - 1] && A[i] > A[i + 1]) {
                return i;
            }
        }
        return -1;
    }

    public int peakIndexInMountainArray2(int[] A) {
        int left = 0, right = A.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            // 左边
            if (A[mid] < A[mid + 1]) {
                left = mid + 1;
                // 右边
            } else if (A[mid - 1] > A[mid]) {
                right = mid;
            } else {
                return mid;
            }
        }
        return 0;
    }

}
