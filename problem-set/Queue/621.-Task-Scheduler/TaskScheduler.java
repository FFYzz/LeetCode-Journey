/**
 * @Title:
 * @Author: FFYzz
 * @Mail: cryptochen95 at gmail dot com
 * @Date: 2020/11/11
 */
public class TaskScheduler {

    public int leastInterval(char[] tasks, int n) {
        int[] chars = new int[26];
        int max = 0;
        int maxCount = 0;
        for (int i = 0; i < tasks.length; ++i) {
            chars[tasks[i] - 'A']++;
            if (max < chars[tasks[i] - 'A']) {
                max = chars[tasks[i] - 'A'];
                maxCount = 1;
            } else if (max == chars[tasks[i] - 'A']) {
                maxCount++;
            }
        }
        int partSlot = max - 1;
        int partLength = n - (maxCount - 1);
        int emptySlots = partSlot * partLength;
        int leftTasks = tasks.length - maxCount * max;
        int idles = Math.max(0, emptySlots - leftTasks);
        return tasks.length + idles;
    }

}
