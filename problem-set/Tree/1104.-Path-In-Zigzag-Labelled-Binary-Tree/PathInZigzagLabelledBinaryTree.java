import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Title:
 * @Author: FFYzz
 * @Mail: cryptochen95 at gmail dot com
 * @Date: 2020/12/10
 */
public class PathInZigzagLabelledBinaryTree {

    public List<Integer> pathInZigZagTree(int label) {
        List<Integer> res = new ArrayList<>();
        List<Integer> midList = new ArrayList<>();
        int value = 0, level = 0, index = 0;
        boolean leftToRight = true;
        while (value < label) {
            int range = (int) Math.pow(2, level);
            int maxValue = value + range;
            int midVale = maxValue;
            while (range-- > 0) {
                if (leftToRight) {
                    midList.add(++value);
                } else {
                    midList.add(midVale--);
                }
                if (value == label || midVale + 1 == label) {
                    index = midList.size() - 1;
                }
            }
            ++level;
            value = maxValue;
            leftToRight = !leftToRight;
        }
        while (index > 0) {
            res.add(0, midList.get(index));
            index = (index - 1) / 2;
        }
        res.add(0, 1);
        return res;
    }

    /**
     * better solution
     *
     * @param label
     * @return
     */
    public List<Integer> pathInZigZagTree2(int label) {
        LinkedList<Integer> result = new LinkedList<>();
        int parent = label;
        result.addFirst(parent);

        while (parent != 1) {
            int d = (int) (Math.log(parent) / Math.log(2));
            int offset = (int) Math.pow(2, d + 1) - 1 - parent;
            parent = ((int) Math.pow(2, d) + offset) / 2;
            result.addFirst(parent);
        }

        return result;
    }

}
