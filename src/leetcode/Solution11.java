package leetcode;

/**
 * Note:
 * 这道题最粗暴的方法当然是O(n^2)，当然对于medium难度的题目来说，显然不能这么做
 * 这道题要解决的问题是，找寻最大的一组(i,j)，使得Area最大。
 *
 * 这里用到了动态规划，基本的表达式:
 * Area = max(min(height[i], height[j]) * (j-i)) {其中0 <= i < j < height,size()}
 *
 * 使用两个指针，向内移动，减小了搜索空间
 * 两线段之间形成的区域总是会受到其中较短那条长度的限制。此外，两线段距离越远，得到的面积就越大。
 * 移动指针，距离必定会缩小。
 * 如果移动值大的指针，即使值变得更大了，高度还是取那个值小指针的值。
 * 这就相当于高度不变，底反而变短了，这样的移动没有意义。
 * 因此【值大的指针不动，而值小的指针向内移动遍历】
 */
public class Solution11 {
    public int maxArea(int[] height) {
        int len = height.length;

        int begin = 0;
        int end = len - 1;
        int area = 0;
        int h;
        while (begin < end) {
            h = Math.min(height[begin], height[end]);
            area = Math.max(area,  h * (end - begin));
            if (height[begin] > height[end])
                --end;
            else
                ++begin;
        }

        return area;
    }

    public static void main(String[] args) {
        int[] heights = {10,20,1,1,1,1,1,1,1,1,5};

        Solution11 s = new Solution11();
        s.maxArea(heights);
    }
}
