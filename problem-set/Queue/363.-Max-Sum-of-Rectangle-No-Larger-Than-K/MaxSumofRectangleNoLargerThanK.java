import java.util.TreeSet;

/**
 * @Title:
 * @Author: FFYzz
 * @Mail: cryptochen95 at gmail dot com
 * @Date: 2020/12/18
 */
public class MaxSumofRectangleNoLargerThanK {

    public int maxSumSubmatrix(int[][] matrix, int k) {
        int rows = matrix.length;
        int column = matrix[0].length;
        int res = Integer.MIN_VALUE;
        for (int left = 0; left < column; ++left) {
            int[] subMax = new int[rows];
            for (int right = left; right < column; ++right) {
                for (int i = 0; i < rows; ++i) {
                    subMax[i] += matrix[i][right];
                }
                int currSum = 0;
                TreeSet<Integer> set = new TreeSet<Integer>();
                set.add(0);
                for (int s : subMax) {
                    currSum += s;
                    Integer find = set.ceiling(currSum - k);
                    if (find != null) {
                        res = Math.max(res, currSum - find);
                    }
                    set.add(currSum);
                }
            }
        }
        return res;
    }

}
