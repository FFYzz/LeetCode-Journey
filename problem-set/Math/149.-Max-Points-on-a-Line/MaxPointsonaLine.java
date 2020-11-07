import java.util.HashMap;
import java.util.Map;

/**
 * @Title:
 * @Author: FFYzz
 * @Mail: cryptochen95 at gmail dot com
 * @Date: 2020/11/7
 */
public class MaxPointsonaLine {

    public int maxPoints(int[][] points) {
        if (points == null) {
            return 0;
        }
        if (points.length <= 2) {
            return points.length;
        }
        int res = 0;
        for (int i = 0; i < points.length; ++i) {
            // x,y count
            Map<String, Integer> map = new HashMap<>();
            int duplicate = 0, max = 0;
            for (int j = i + 1; j < points.length; ++j) {
                int deltaX = points[i][0] - points[j][0];
                int deltaY = points[i][1] - points[j][1];
                if (deltaX == 0 && deltaY == 0) {
                    duplicate++;
                    continue;
                }
                int gcd = gcd(deltaX, deltaY);
                deltaX /= gcd;
                deltaY /= gcd;
                map.put(deltaX + "," + deltaY, map.getOrDefault(deltaX + "," + deltaY, 0) + 1);
                max = Math.max(max, map.get(deltaX + "," + deltaY));
            }
            res = Math.max(res, max + duplicate + 1);
        }
        return res;
    }

    private int gcd(int deltaX, int deltaY) {
        if (deltaY == 0) {
            return deltaX;
        }
        return gcd(deltaY, deltaX % deltaY);
    }

}
