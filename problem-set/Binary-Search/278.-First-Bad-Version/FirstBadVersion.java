/**
 * @Title: 278. First Bad Version
 * @Author: FFYzz
 * @Mail: cryptochen95 at gmail dot com
 * @Date: 2020/5/1
 */
public class FirstBadVersion {

    /**
     * 其实是一个有序的 false false ... true true ... 的序列
     * 只要找到第一个返回为 true 就可以了
     *
     * @param n
     * @return
     */
    public int firstBadVersion(int n) {
        int left = 1, right = n;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (!isBadVersion(mid)) {
                left = mid + 1;
            } else {
                if (mid == 1 || !isBadVersion(mid - 1)) {
                    return mid;
                }
                right = mid - 1;
            }
        }
        return -1;
    }

    /**
     * fake method, only for test
     *
     * @param n
     * @return
     */
    public boolean isBadVersion(int n) {
        return false;
    }

}
