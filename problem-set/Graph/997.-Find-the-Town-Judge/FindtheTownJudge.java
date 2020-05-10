/**
 * @Title: 997. Find the Town Judge
 * @Author: FFYzz
 * @Mail: cryptochen95 at gmail dot com
 * @Date: 2020/5/10
 */
public class FindtheTownJudge {

    public int findJudge(int N, int[][] trust) {
        if (trust.length == 0) {
            return 1;
        }
        int[] countTrusted = new int[N + 1];
        int[] countTruster = new int[N + 1];
        int targetJudge = -1;
        for (int i = 0; i < trust.length; ++i) {
            countTruster[trust[i][0]]++;
            countTrusted[trust[i][1]]++;
            if (countTrusted[trust[i][1]] == N - 1) {
                targetJudge = trust[i][1];
            }
        }
        return targetJudge == -1 || countTruster[targetJudge] == 0 ? targetJudge : -1;
    }

    // 3
    // [[1,2],[2,3]]

}
