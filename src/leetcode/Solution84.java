package leetcode;

/**
 * 【柱状图中最大的矩形】
 * Note:
 * 1. 不要想着先处理数据，再分析数据，通常做题是边处理边分析的，这样效率高。
 */
public class Solution84 {
    public int largestRectangleArea(int[] heights) {
        int barCount = heights.length;

        int area = 0;
        int minHeight = 0;
        for (int i = 0; i < barCount; i++) {
            // 自身的面积
            area = Math.max(area, heights[i]);
            minHeight = heights[i];

            // 与之前的height做合并
            // 前面的数据已经算出来了，只考虑从当前位置出发的面积
            for (int j = i - 1; j >= 0; j--) {
                minHeight = Math.min(minHeight, heights[j]);

                area = Math.max(area, minHeight * (i - j + 1));
            }
        }

        return area;
    }

    public static void main(String[] args) {
        int[] heights = {1,1};

        Solution84 s = new Solution84();
        s.largestRectangleArea(heights);
    }
}
