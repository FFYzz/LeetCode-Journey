import java.util.Arrays;

/**
 * @Title: 931. Minimum Falling Path Sum
 * @Author: FFYzz
 * @Mail: cryptochen95@gmail.com
 * @Date: 2020/3/14
 */
public class MinimumFallingPathSum {

    public int minFallingPathSum(int[][] A) {
        for (int i = 1; i < A.length; ++i) {
            for (int j = 0; j < A[0].length; ++j) {
                A[i][j] = A[i][j] + Math.min(Math.min(A[i - 1][Math.max(0, j - 1)], A[i - 1][j]), A[i - 1][Math.min(j + 1, A[0].length - 1)]);
            }
        }
        return Arrays.stream(A[A.length - 1]).min().getAsInt();
    }

}
