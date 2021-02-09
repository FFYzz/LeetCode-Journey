import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * @Title:
 * @Author: FFYzz
 * @Mail: cryptochen95 at gmail dot com
 * @Date: 2021/2/9
 * @Description:
 */
public class IntersectionofTwoArrays {

    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> res = new HashSet<>();
        Set<Integer> num1Set = new HashSet<>();
        Arrays.stream(nums1).forEach(x -> num1Set.add(x));
        Arrays.stream(nums2).forEach(x -> {
            if (num1Set.contains(x)) {
                res.add(x);
            }
        });
        int[] resArray = new int[res.size()];
        int index = 0;
        Iterator<Integer> iterator = res.iterator();
        while (iterator.hasNext()) {
            resArray[index++] = iterator.next();
        }
        return resArray;
    }

}
