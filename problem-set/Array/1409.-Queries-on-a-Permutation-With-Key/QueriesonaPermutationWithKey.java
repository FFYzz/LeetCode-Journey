/**
 * @Title: 1409. Queries on a Permutation With Key
 * @Author: FFYzz
 * @Mail: cryptochen95@gmail.com
 * @Date: 2020/4/13
 */
public class QueriesonaPermutationWithKey {

    public int[] processQueries(int[] queries, int m) {
        int[] res = new int[queries.length];
        int[] per = new int[m];
        for (int i = 1; i <= m; ++i) {
            per[i - 1] = i;
        }
        for (int i = 0; i < queries.length; ++i) {
            for (int j = 0; j < m; ++j) {
                if (queries[i] == per[j]) {
                    res[i] = j;
                    move(per, j);
                }
            }
        }
        return res;
    }

    public void move(int[] arr, int index) {
        if (index == 0) {
            return;
        }
        int value = arr[index];
        for (int i = index; i > 0; --i) {
            arr[i] = arr[i - 1];
        }
        arr[0] = value;
    }

}
