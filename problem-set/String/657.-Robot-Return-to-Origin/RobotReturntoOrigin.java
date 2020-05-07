/**
 * @Title: 657. Robot Return to Origin
 * @Author: FFYzz
 * @Mail: cryptochen95 at gmail dot com
 * @Date: 2020/5/7
 */
public class RobotReturntoOrigin {

    public boolean judgeCircle(String moves) {
        int[] p = new int[2];
        for (char c : moves.toCharArray()) {
            if (c == 'U') {
                p[0]++;
            } else if (c == 'D') {
                p[0]--;
            } else if (c == 'L') {
                p[1]++;
            } else {
                p[1]--;
            }
        }
        return p[0] == 0 && p[1] == 0;
    }

}
