/**
 * @Title:
 * @Author: FFYzz
 * @Mail: cryptochen95 at gmail dot com
 * @Date: 2020/12/13
 */
public class CountofMatchesinTournament {

    public int numberOfMatches(int n) {
        int res = 0;
        while (n != 1) {
            if ((n & 1) == 1) {
                res += (n - 1) / 2;
                n = (n - 1) / 2 + 1;
            } else {
                res += n / 2;
                n = n / 2;
            }
        }
        return res;
    }

}
