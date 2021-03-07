import java.util.Arrays;

/**
 * @Title:
 * @Author: FFYzz
 * @Mail: cryptochen95 at gmail dot com
 * @Date: 2021/3/7
 * @Description:
 */
public class DesignHashMap {

    private int[] container;

    /** Initialize your data structure here. */
    public DesignHashMap() {
        container = new int[1000000 + 1];
        Arrays.fill(container, -1);
    }

    /** value will always be non-negative. */
    public void put(int key, int value) {
        container[key] = value;
    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        if (container[key] == -1) {
            return -1;
        }
        return container[key];
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        container[key] = -1;
    }

}
