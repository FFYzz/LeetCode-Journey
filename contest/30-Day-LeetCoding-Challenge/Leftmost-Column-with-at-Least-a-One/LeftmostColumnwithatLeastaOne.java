import java.util.List;

/**
 * @Title: Leftmost Column with at Least a One
 * @Author: FFYzz
 * @Mail: cryptochen95 at gmail dot com
 * @Date: 2020/4/21
 */
public class LeftmostColumnwithatLeastaOne {

    /**
     * from upper-right -> lower-left
     *
     * @param binaryMatrix
     * @return
     */
    public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
        List<Integer> list = binaryMatrix.dimensions();
        int row = list.get(0), column = list.get(1), pointX = 0, pointY = column - 1, res = -1;
        while (pointX < row && pointY >= 0) {
            if (binaryMatrix.get(pointX, pointY) == 0) {
                pointX++;
            } else {
                res = pointY;
                pointY--;
            }
        }
        return res;
    }

    /**
     * binary search solution
     *
     * @param binaryMatrix
     * @return
     */
    public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
        List<Integer> list = binaryMatrix.dimensions();
        int row = list.get(0), column = list.get(1), left = 0, right = column - 1, res = -1;
        boolean find = false;
        while (left <= right) {
            find = false;
            int mid = left + (right - left) / 2;
            for (int i = 0; i < row; ++i) {
                if (binaryMatrix.get(i, mid) == 1) {
                    find = true;
                    right = mid - 1;
                    res = mid;
                    break;
                }
            }
            left = find ? left : mid + 1;
        }
        return res;
    }

}


interface BinaryMatrix {
    public int get(int x, int y);

    public List<Integer> dimensions();
}
