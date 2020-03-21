import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @Title: 1329. Sort the Matrix Diagonally
 * @Author: FFYzz
 * @Mail: cryptochen95@gmail.com
 * @Date: 2020/3/21
 */
public class SorttheMatrixDiagonally {

    public int[][] diagonalSort(int[][] mat) {
        Map<Integer, PriorityQueue<Integer>> map = new HashMap<>();
        for (int i = 0; i < mat.length; ++i) {
            for (int j = 0; j < mat[0].length; ++j) {
                map.putIfAbsent(i - j, new PriorityQueue<>());
                map.get(i - j).add(mat[i][j]);
            }
        }
        for (int i = 0; i < mat.length; ++i) {
            for (int j = 0; j < mat[0].length; ++j) {
                mat[i][j] = map.get(i - j).poll();
            }
        }
        return mat;
    }

}
