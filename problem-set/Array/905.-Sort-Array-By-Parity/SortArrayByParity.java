/**
 * @Title: 905. Sort Array By Parity
 * @Author: FFYzz
 * @Mail: cryptochen95 at gmail dot com
 * @Date: 2020/5/21
 */
public class SortArrayByParity {

    public int[] sortArrayByParity(int[] A) {
        for (int i = 0, j = 0; j < A.length; ++j) {
            if ((A[j] & 1) == 0) {
                int temp = A[j];
                A[j] = A[i];
                A[i++] = temp;
            }
        }
        return A;

    }

}
