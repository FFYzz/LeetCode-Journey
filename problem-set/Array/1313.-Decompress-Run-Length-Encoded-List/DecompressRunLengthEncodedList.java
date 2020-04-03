import java.util.ArrayList;
import java.util.List;

/**
 * @Title: 1313. Decompress Run-Length Encoded List
 * @Author: FFYzz
 * @Mail: cryptochen95@gmail.com
 * @Date: 2020/4/3
 */
public class DecompressRunLengthEncodedList {

    public int[] decompressRLElist(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i += 2) {
            while (nums[i]-- > 0) {
                res.add(nums[i + 1]);
            }
        }
        return res.stream().mapToInt(Integer::intValue).toArray();
    }

}
