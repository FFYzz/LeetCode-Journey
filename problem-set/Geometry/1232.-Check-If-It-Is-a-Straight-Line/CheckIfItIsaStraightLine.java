/**
 * @Title: 1232. Check If It Is a Straight Line
 * @Author: FFYzz
 * @Mail: cryptochen95 at gmail dot com
 * @Date: 2020/5/8
 */
public class CheckIfItIsaStraightLine {

    /**
     * 比较斜率
     *
     * @param coordinates
     * @return
     */
    public boolean checkStraightLine(int[][] coordinates) {
        if (coordinates.length == 2) {
            return true;
        }
        for (int i = 1; i < coordinates.length - 1; ++i) {
            if ((coordinates[i][1] - coordinates[0][1]) * (coordinates[i + 1][0] - coordinates[i][0]) !=
                    (coordinates[i + 1][1] - coordinates[i][1]) * (coordinates[i][0] - coordinates[0][0])) {
                return false;
            }
        }
        return true;
    }

}
