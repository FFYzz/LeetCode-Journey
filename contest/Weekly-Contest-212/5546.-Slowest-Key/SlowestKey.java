/**
 * @Title:
 * @Author: FFYzz
 * @Mail: cryptochen95 at gmail dot com
 * @Date: 2020/10/25
 */
public class SlowestKey {

    public char slowestKey(int[] releaseTimes, String keysPressed) {
        int logestTime = releaseTimes[0];
        int longestTimeIndex = 0;
        for (int i = 1; i < releaseTimes.length; ++i) {
            if (releaseTimes[i] - releaseTimes[i - 1] >= logestTime) {
                if (releaseTimes[i] - releaseTimes[i - 1] == logestTime
                        && keysPressed.charAt(i) < keysPressed.charAt(longestTimeIndex)) {
                    continue;
                }
                logestTime = releaseTimes[i] - releaseTimes[i - 1];
                longestTimeIndex = i;
            }
        }
        return keysPressed.charAt(longestTimeIndex);
    }

}
