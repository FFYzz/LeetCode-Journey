package leetcode;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * @Title: 1476. Subrectangle Queries
 * @Author: FFYzz
 * @Mail: cryptochen95 at gmail dot com
 * @Date: 2020/9/4
 */
public class SubrectangleQueries {

    int[][] rectangle;

//    public SubrectangleQueries(int[][] rectangle) {
//        this.rectangle = rectangle;
//    }
//
//    public void updateSubrectangle(int row1, int col1, int row2, int col2, int newValue) {
//        for (int i = row1; i <= row2; ++i) {
//            for (int j = col1; j <= col2; ++j) {
//                rectangle[i][j] = newValue;
//            }
//        }
//    }

    /**
     * stack
     */
    LinkedList<int[]> queue = new LinkedList();

    public SubrectangleQueries(int[][] rectangle) {
        this.rectangle = rectangle;
    }

    public void updateSubrectangle(int row1, int col1, int row2, int col2, int newValue) {
        queue.push(new int[]{row1, row2, col1, col2, newValue});
    }

    public int getValue(int row, int col) {
        for (int[] data : queue) {
            if (row >= data[0] && row <= data[1] && col >= data[2] && col <= data[3]) return data[4];
        }
        return rectangle[row][col];
    }
}

/**
 * Your SubrectangleQueries object will be instantiated and called as such:
 * SubrectangleQueries obj = new SubrectangleQueries(rectangle);
 * obj.updateSubrectangle(row1,col1,row2,col2,newValue);
 * int param_2 = obj.getValue(row,col);
 */