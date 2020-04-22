/**
 * @Title: 977. Squares of a Sorted Array
 * @Author: FFYzz
 * @Mail: cryptochen95 at gmail dot com
 * @Date: 2020/4/22
 */
public class SquaresofaSortedArray {

    public int[] sortedSquares(int[] A) {
        int startIndexOfNoneNegativeNumber = 0, res[] = new int[A.length], count = 0;
        for (int i = 0; i < A.length; ++i) {
            if (A[i] >= 0) {
                startIndexOfNoneNegativeNumber = i;
                break;
            }
        }
        int slower = startIndexOfNoneNegativeNumber - 1, faster = startIndexOfNoneNegativeNumber;
        while (slower >= 0 || faster < A.length) {
            if (slower >= 0 && faster < A.length) {
                res[count++] = (int) Math.pow(Math.min(-A[slower], A[faster]), 2);
                if (-A[slower] > A[faster]) {
                    ++faster;
                } else {
                    --slower;
                }
            } else {
                while (slower >= 0) {
                    res[count++] = (int) Math.pow(A[slower--], 2);
                }
                while (faster < A.length) {
                    res[count++] = (int) Math.pow(A[faster++], 2);
                }
            }
        }
        return res;
    }

    /**
     * clean code of two pointers
     *
     * @param A
     * @return
     */
    public int[] sortedSquares2(int[] A) {
        int left = 0, right = A.length - 1, res[] = new int[A.length], position = right;
        for (int i = position; i >= 0; --i) {
            if (Math.abs(A[left]) > Math.abs(A[right])) {
                res[i] = (int) Math.pow(A[left++], 2);
            } else {
                res[i] = (int) Math.pow(A[right--], 2);
            }
        }
        return res;
    }


}
