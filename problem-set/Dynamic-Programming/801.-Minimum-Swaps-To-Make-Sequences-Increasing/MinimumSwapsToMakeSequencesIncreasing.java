/**
 * @Title:
 * @Author: FFYzz
 * @Mail: cryptochen95 at gmail dot com
 * @Date: 2021/1/19
 * @Description:
 */
public class MinimumSwapsToMakeSequencesIncreasing {

    public int minSwap(int[] A, int[] B) {
        int swapCount = 1, fixCount = 0;
        for (int i = 1; i < A.length; ++i) {
            if (A[i - 1] >= B[i] || B[i - 1] >= A[i]) {
                swapCount++;
            } else if (A[i - 1] >= A[i] || B[i - 1] >= B[i]) {
                int tmp = swapCount;
                swapCount = fixCount + 1;
                fixCount = tmp;
            } else {
                int min = Math.min(swapCount, fixCount);
                swapCount = min + 1;
                fixCount = min;
            }
        }
        return Math.min(swapCount, fixCount);
    }

}
