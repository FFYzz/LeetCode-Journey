/**
 * @Title: 1105. Filling Bookcase Shelves
 * @Author: FFYzz
 * @Mail: cryptochen95@gmail.com
 * @Date: 2020/3/9
 */
public class FillingBookcaseShelves {

    public int minHeightShelves(int[][] books, int shelf_width) {
        if (books == null || books.length == 0) {
            return 0;
        }
        // dp[i] 表示到第 i 本书构成的书架的最小高度
        int[] dp = new int[books.length + 1];
        // 初始化 没有书时高度为 0
        dp[0] = 0;
        for (int i = 1; i <= books.length; ++i) {
            // 当前书架层的高度
            int height = books[i - 1][1];
            // 当前书架层的厚度
            int thick = books[i - 1][0];
            // 最坏情况下当前书本新增一层
            dp[i] = dp[i - 1] + height;
            // 往前找 观察是否可以合并到上一层书架中
            // 只要厚度充足 就可以合并
            for (int j = i - 1; j > 0 && thick + books[j - 1][0] <= shelf_width; --j) {
                thick += books[j - 1][0];
                height = Math.max(height, books[j - 1][1]);
                dp[i] = Math.min(dp[i], dp[j - 1] + height);
            }
        }
        return dp[books.length];
    }

}
