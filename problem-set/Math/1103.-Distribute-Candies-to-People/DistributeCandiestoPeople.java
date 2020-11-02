/**
 * @Title:
 * @Author: FFYzz
 * @Mail: cryptochen95 at gmail dot com
 * @Date: 2020/11/2
 */
public class DistributeCandiestoPeople {

    public int[] distributeCandies(int candies, int num_people) {
        int[] res = new int[num_people];
        int index = 0;
        while (candies > 0) {
            res[index % num_people] += Math.min(candies, ++index);
            candies -= index;
        }
        return res;
    }

}
