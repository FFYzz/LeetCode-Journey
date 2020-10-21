import java.util.*;

/**
 * @Title:
 * @Author: FFYzz
 * @Mail: cryptochen95 at gmail dot com
 * @Date: 2020/10/21
 */
public class EmployeeImportance {

    public int getImportance(List<Employee> employees, int id) {
        if (employees == null || employees.size() == 0) {
            return 0;
        }
        Map<Integer, Employee> map = new HashMap<>();
        for (Employee e : employees) {
            map.put(e.id, e);
        }
        Deque<Employee> queue = new LinkedList<>();
        Employee targetEmployee = map.get(id);
        if (targetEmployee == null) {
            return 0;
        }
        int value = 0;
        queue.offer(targetEmployee);
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                Employee e = queue.poll();
                value += e.importance;
                for (int uniqueId : e.subordinates) {
                    queue.add(map.get(uniqueId));
                }
            }
        }
        return value;
    }

    class Employee {

        public int id;
        public int importance;
        public List<Integer> subordinates;

    }

}
