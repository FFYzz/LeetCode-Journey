/**
 * @Title: 733. Flood Fill
 * @Author: FFYzz
 * @Mail: cryptochen95 at gmail dot com
 * @Date: 2020/5/11
 */
public class FloodFill {

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image[sr][sc] == newColor) {
            return image;
        }
        fill(image, sr, sc, image[sr][sc], newColor);
        return image;
    }

    public void fill(int[][] image, int sr, int sc, int oldColor, int newColor) {
        if (sr < 0 || sr >= image.length || sc < 0 || sc >= image[0].length || image[sr][sc] != oldColor) {
            return;
        }
        image[sr][sc] = newColor;
        fill(image, sr + 1, sc, oldColor, newColor);
        fill(image, sr - 1, sc, oldColor, newColor);
        fill(image, sr, sc + 1, oldColor, newColor);
        fill(image, sr, sc - 1, oldColor, newColor);
    }

    public static void main(String[] args) {
        new FloodFill().floodFill(new int[][]{{1, 1, 1}, {1, 1, 0}, {1, 0, 1}}, 1, 1, 2);
    }
    //[[1,1,1],[1,1,0],[1,0,1]]
    //1
    //1
    //2

}
