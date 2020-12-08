import java.util.ArrayList;
import java.util.List;

/**
 * @Title:
 * @Author: FFYzz
 * @Mail: cryptochen95 at gmail dot com
 * @Date: 2020/12/9
 */
public class PrintBinaryTree {

    public List<List<String>> printTree(TreeNode root) {
        List<List<String>> res = new ArrayList<>();
        int rows = getHeight(root);
        int cols = (int) (Math.pow(2, rows) - 1);
        List<String> row = new ArrayList<>();
        for (int i = 0; i < cols; ++i) {
            row.add("");
        }
        for (int i = 0; i < rows; ++i) {
            res.add(new ArrayList<>(row));
        }
        setValue(root, res, 0, rows, 0, cols - 1);
        return res;
    }

    private void setValue(TreeNode root, List<List<String>> res, int currRow, int totalRows, int leftIndex, int rightIndex) {
        if (root == null || currRow == totalRows) {
            return;
        }
        res.get(currRow).set((leftIndex + rightIndex) / 2, String.valueOf(root.val));
        setValue(root.left, res, currRow + 1, totalRows, leftIndex, (leftIndex + rightIndex) / 2 - 1);
        setValue(root.right, res, currRow + 1, totalRows, (leftIndex + rightIndex) / 2 + 1, rightIndex);
    }

    private int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(getHeight(root.left), getHeight(root.right));
    }

}
