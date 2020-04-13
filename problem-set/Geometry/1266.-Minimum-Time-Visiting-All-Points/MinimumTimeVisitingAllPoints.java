/**
 * @Title: 1266. Minimum Time Visiting All Points
 * @Author: FFYzz
 * @Mail: cryptochen95 at gmail dot com
 * @Date: 2020/4/13
 */
public class MinimumTimeVisitingAllPoints {

    /**
     * greedy
     *
     * @param points
     * @return
     */
    public int minTimeToVisitAllPoints(int[][] points) {
        int res = 0;
        for (int i = 0; i < points.length - 1; ++i) {
            res += Math.max(Math.abs(points[i][0] - points[i + 1][0]), Math.abs(points[i][1] - points[i + 1][1]));
        }
        return res;
    }
}
