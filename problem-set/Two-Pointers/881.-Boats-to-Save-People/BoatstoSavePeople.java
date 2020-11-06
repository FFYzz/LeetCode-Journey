import java.util.Arrays;

/**
 * @Title:
 * @Author: FFYzz
 * @Mail: cryptochen95 at gmail dot com
 * @Date: 2020/11/6
 */
public class BoatstoSavePeople {

    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int l = 0, r = people.length - 1, count = 0;
        while (l < r) {
            if (people[r] + people[l] <= limit) {
                l++;
                r--;
            } else {
                r--;
            }
            count++;
        }
        if (l == r) {
            ++count;
        }
        return count;
    }

}
