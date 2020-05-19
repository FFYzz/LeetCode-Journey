import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @Title: 901. Online Stock Span
 * @Author: FFYzz
 * @Mail: cryptochen95 at gmail dot com
 * @Date: 2020/5/19
 */
public class StockSpanner {

    /**
     * 用来保存所有的元素
     */
    List<Integer> list;
    /**
     * 保存元素以及连续比当前元素小的元素的个数
     * key : count
     * value : 连续比在 key 位置小的元素的个数
     */
    HashMap<Integer, Integer> map;

    public StockSpanner() {
        map = new HashMap<>();
        list = new ArrayList<>();
    }

    public int next(int price) {
        list.add(price);
        int days = list.size();
        if (days == 1 || price < list.get(days - 2)) {
            map.put(days - 1, 1);
            return 1;
        } else {
            int count = 1, preDay = days - 2;
            while (preDay >= 0 && price >= list.get(preDay)) {
                count += map.get(preDay);
                preDay -= map.get(preDay);
            }
            map.put(days - 1, count);
            return count;
        }
    }

    public static void main(String[] args) {
        StockSpanner span = new StockSpanner();
        System.out.println(span.next(31));
        System.out.println(span.next(41));
        System.out.println(span.next(48));
        System.out.println(span.next(59));
        System.out.println(span.next(79));
    }

    //["StockSpanner","next","next","next","next","next"]
    //[[],[31],[41],[48],[59],[79]]
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */
