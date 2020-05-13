import java.util.ArrayList;
import java.util.List;

/**
 * @Title: 763. Partition Labels
 * @Author: FFYzz
 * @Mail: cryptochen95 at gmail dot com
 * @Date: 2020/5/13
 */
public class PartitionLabels {

    public List<Integer> partitionLabels(String S) {
        List<Integer> res = new ArrayList<>();
        int[] arr = new int[26];
        for (int i = 0; i < S.length(); ++i) {
            arr[S.charAt(i) - 'a'] = i;
        }
        int maxDistance = 0, start = 0;
        for (int i = 0; i < S.length(); ++i) {
            maxDistance = Math.max(maxDistance, arr[S.charAt(i) - 'a']);
            if (maxDistance == i) {
                res.add(maxDistance - start + 1);
                start = i + 1;
            }
        }
        return res;
    }

}
