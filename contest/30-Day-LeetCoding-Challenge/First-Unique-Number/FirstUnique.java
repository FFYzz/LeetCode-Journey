import java.util.HashMap;
import java.util.LinkedList;

/**
 * @Title: First Unique Number
 * @Author: FFYzz
 * @Mail: cryptochen95 at gmail dot com
 * @Date: 2020/4/28
 */
public class FirstUnique {

    private LinkedList<Integer> recordUniqueElements;
    private HashMap<Integer, Integer> repeatedElement;

    public FirstUnique(int[] nums) {
        recordUniqueElements = new LinkedList<>();
        repeatedElement = new HashMap<>();
        for (int num : nums) {
            add(num);
        }
    }

    public int showFirstUnique() {
        if (recordUniqueElements.size() == 0) {
            return -1;
        }
        while (recordUniqueElements.size() > 0 && repeatedElement.containsKey(recordUniqueElements.peek()) && repeatedElement.get(recordUniqueElements.peek()) >= 2) {
            recordUniqueElements.poll();
        }
        return recordUniqueElements.size() > 0 ? recordUniqueElements.peek() : -1;
    }

    public void add(int value) {
        repeatedElement.put(value, repeatedElement.getOrDefault(value, 0) + 1);
        recordUniqueElements.offer(value);
    }


}
