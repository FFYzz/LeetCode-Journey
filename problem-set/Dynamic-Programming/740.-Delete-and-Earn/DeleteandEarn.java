/**
 * @Title:
 * @Author: FFYzz
 * @Mail: cryptochen95 at gmail dot com
 * @Date: 2021/1/1
 */
public class DeleteandEarn {

    public int deleteAndEarn(int[] nums) {
        int n = 10001;
        int[] bucket = new int[n];
        for (int num : nums) {
            bucket[num] += num;
        }
        int take = 0, skip = 0;
        for (int i = 0; i < n; ++i) {
            // takei 当前 i 取的情况下的最大和
            int takei = skip + bucket[i];
            // skipi 当前 i 不取的情况下的最大和
            int skipi = Math.max(skip, take);
            // 传递下去
            take = takei;
            skip = skipi;
        }
        return Math.max(take, skip);
    }

}
