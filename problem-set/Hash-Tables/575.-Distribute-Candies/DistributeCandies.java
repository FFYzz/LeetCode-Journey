import java.util.*;

/**
 * @Title:
 * @Author: FFYzz
 * @Mail: cryptochen95 at gmail dot com
 * @Date: 2020/11/2
 */
public class DistributeCandies {

    public int distributeCandiesWithHashMap(int[] candies) {
        int half = candies.length / 2, numOfOne = candies.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < candies.length; ++i) {
            if (map.containsKey(candies[i])) {
                --numOfOne;
                map.put(candies[i], map.get(candies[i]) + 1);
            } else {
                map.put(candies[i], 1);
            }
        }
        return numOfOne > half ? half : numOfOne;
    }

    public int distributeCandiesWithSet(int[] candies) {
        Set<Integer> set = new HashSet<>();
        Arrays.stream(candies).forEach(x -> set.add(x));
        return set.size() > candies.length / 2 ? candies.length / 2 : set.size();
    }

    public int distributeCandiesWithSetWithoutStream(int[] candies) {
        Set<Integer> set = new HashSet<>();
        for (int num : candies) {
            set.add(num);
        }
        return set.size() > candies.length / 2 ? candies.length / 2 : set.size();
    }

}
