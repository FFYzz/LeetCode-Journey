import java.util.HashMap;
import java.util.Map;

/**
 * @Title:
 * @Author: FFYzz
 * @Mail: cryptochen95 at gmail dot com
 * @Date: 2021/2/1
 * @Description:
 */
public class LengthofLongestFibonacciSubsequence {

    public int lenLongestFibSubseq(int[] arr) {
        int max = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; ++i) {
            map.put(arr[i], i);
        }
        for (int i = arr.length - 1; i >= 2; --i) {
            for (int j = i - 1; j >= 1; --j) {
                int count = 0;
                int third = arr[i];
                int second = arr[j];
                while (map.containsKey(third - second) && map.get(third - second) < map.get(second)) {
                    ++count;
                    int v = third - second;
                    third = second;
                    second = v;
                }
                max = Math.max(count, max);
            }
        }
        return max == 0 ? 0 : max + 2;
    }

    public static void main(String[] args) {
        new LengthofLongestFibonacciSubsequence().lenLongestFibSubseq(new int[]{1, 2, 3, 4, 5, 6, 7, 8});
    }

}