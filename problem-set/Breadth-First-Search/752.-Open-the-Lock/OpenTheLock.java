import java.util.*;

/**
 * @Title:
 * @Author: FFYzz
 * @Mail: cryptochen95 at gmail dot com
 * @Date: 2021/3/12
 * @Description:
 */
public class OpenTheLock {

    public int openLock(String[] deadends, String target) {
        Set<String> dead = new HashSet<>(Arrays.asList(deadends));
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.offer("0000");
        visited.add("0000");
        int count = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                String str = queue.poll();
                if (str.equals(target)) {
                    return count;
                }
                if (dead.contains(str)) {
                    --size;
                    continue;
                }
                StringBuilder sb = new StringBuilder(str);
                for (int i = 0; i < 4; ++i) {
                    char c = sb.charAt(i);
                    // 可以向上，也可以向下翻
                    String up = sb.substring(0, i) + (c == '0' ? '9' : (char) (c - 1)) + sb.substring(i + 1);
                    String down = sb.substring(0, i) + (c == '9' ? '0' : (char) (c + 1)) + sb.substring(i + 1);
                    if (!visited.contains(up) && !dead.contains(up)) {
                        visited.add(up);
                        queue.offer(up);
                    }
                    if (!visited.contains(down) && !visited.contains(down)) {
                        visited.add(down);
                        queue.offer(down);
                    }
                }
                --size;
            }
            ++count;
        }
        return -1;
    }

    public static void main(String[] args) {
        new OpenTheLock().openLock(new String[]{"8888"}, "0009");
    }

}
