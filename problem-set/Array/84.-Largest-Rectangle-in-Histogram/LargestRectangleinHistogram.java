/**
 * @Title:
 * @Author: FFYzz
 * @Mail: cryptochen95 at gmail dot com
 * @Date: 2020/10/17
 */
public class LargestRectangleinHistogram {

    /**
     * O(n^2)
     * @param heights
     * @return
     */
    public int largestRectangleArea2(int[] heights) {
        if (heights.length == 0) {
            return 0;
        }
        int maxArea = 0;
        for (int i = 0; i < heights.length; ++i) {
            int leftIndex = i - 1, rightIndex = i + 1;
            while (leftIndex >= 0 && heights[leftIndex] >= heights[i]) {
                --leftIndex;
            }
            while (rightIndex < heights.length && heights[rightIndex] >= heights[i]) {
                ++rightIndex;
            }
            maxArea = Math.max(maxArea, (rightIndex - leftIndex - 1) * heights[i]);
        }
        return maxArea;
    }

    /**
     * O(n)
     * @param heights
     * @return
     */
    public int largestRectangleArea1(int[] heights) {
        if (heights.length == 0) {
            return 0;
        }
        // 最左有效下标的左边一位
        int[] left = new int[heights.length];
        // 最右有效下标的右边一位
        int[] right = new int[heights.length];
        left[0] = -1;
        right[heights.length - 1] = heights.length;
        int maxArea = 0;
        for (int i = 1; i < heights.length; ++i) {
            int leftIndex = i - 1;
            while (leftIndex >= 0 && heights[leftIndex] >= heights[i]) {
                leftIndex = left[leftIndex];
            }
            left[i] = leftIndex;
        }
        for (int i = heights.length - 2; i >= 0; --i) {
            int rightIndex = i + 1;
            while (rightIndex < heights.length && heights[rightIndex] >= heights[i]) {
                rightIndex = right[rightIndex];
            }
            right[i] = rightIndex;
        }
        for (int i = 0; i < heights.length; ++i) {
            maxArea = Math.max(maxArea, (right[i] - left[i] - 1) * heights[i]);
        }
        return maxArea;
    }

}
