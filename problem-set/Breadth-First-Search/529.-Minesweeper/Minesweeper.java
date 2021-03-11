/**
 * @Title:
 * @Author: FFYzz
 * @Mail: cryptochen95 at gmail dot com
 * @Date: 2021/3/11
 * @Description:
 */
public class Minesweeper {

    public char[][] updateBoard(char[][] board, int[] click) {
        int rows = board.length, columns = board[0].length;
        updateBoard(board, rows, columns, click[0], click[1]);
        return board;
    }

    private void updateBoard(char[][] board, int rows, int columns, int x, int y) {
        if (x < 0 || x >= rows || y < 0 || y >= columns) {
            return;
        }
        if (board[x][y] == 'M') {
            board[x][y] = 'X';
            return;
        }
        int count = countOfMine(board, rows, columns, x, y);
        if (count == 0) {
            board[x][y] = 'B';
            for (int i = -1; i < 2; ++i) {
                for (int j = -1; j < 2; ++j) {
                    if (i == 0 && j == 0) {
                        continue;
                    }
                    int r = x + i, c = y + j;
                    if (r < 0 || r >= rows || c < 0 || c >= columns) {
                        continue;
                    }
                    if (board[r][c] == 'E') {
                        updateBoard(board, rows, columns, x + i, y + j);
                    }
                }
            }
        } else {
            board[x][y] = (char) (count + '0');
        }
    }

    private int countOfMine(char[][] board, int rows, int columns, int x, int y) {
        int count = 0;
        for (int i = -1; i < 2; ++i) {
            for (int j = -1; j < 2; ++j) {
                if (i == 0 && j == 0) {
                    continue;
                }
                if (x + i < 0 || x + i >= rows || y + j < 0 || y + j >= columns) {
                    continue;
                }
                count += (board[x + i][y + j] == 'M' || board[x + i][y + j] == 'X') ? 1 : 0;
            }
        }
        return count;
    }
    // [['E', 'E', 'E', 'E', 'E'],
    //  ['E', 'E', 'M', 'E', 'E'],
    //  ['E', 'E', 'E', 'E', 'E'],
    //  ['E', 'E', 'E', 'E', 'E']]
    //
    // Click : [3,0]

}
