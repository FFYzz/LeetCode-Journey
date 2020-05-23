import java.util.ArrayList;
import java.util.List;

/**
 * @Title: 986. Interval List Intersections
 * @Author: FFYzz
 * @Mail: cryptochen95 at gmail dot com
 * @Date: 2020/5/23
 */
public class IntervalListIntersections {

    public int[][] intervalIntersection(int[][] A, int[][] B) {
        if (A.length == 0 || B.length == 0) {
            return new int[][]{};
        }
        List<int[]> res = new ArrayList<>();
        int indexOfA = 0, indexOfB = 0, leftMax, minRight;
        while (indexOfA < A.length && indexOfB < B.length) {
            leftMax = Math.max(A[indexOfA][0], B[indexOfB][0]);
            minRight = Math.min(A[indexOfA][1], B[indexOfB][1]);
            if (leftMax <= minRight) {
                res.add(new int[]{leftMax, minRight});
            }
            if (minRight == A[indexOfA][1]) {
                ++indexOfA;
            } else {
                ++indexOfB;
            }
        }
        return res.toArray(new int[][]{});
    }

}
