import java.util.HashMap;

/**
 * @Title: Counting Elements
 * @Author: FFYzz
 * @Mail: cryptochen95@gmail.com
 * @Date: 2020/4/7
 */
public class CountingElements {

    public int countElements(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int res = 0;
        for (int num : arr) {
            if (map.containsKey(num + 1)) {
                res++;
            }
        }
        return res;
    }

}
