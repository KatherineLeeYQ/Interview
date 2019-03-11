package leetcode;

/**
 * 【接雨水】：平面坐标系
 * Note:
 * 某个坐标处要形成积水，则需要左右都有高于自身高度的挡板
 * 而积水的高度取决于两个挡板中矮的那一侧
 */
public class Solution42 {
    public int trap(int[] height) {
        // 至少三块方可积水
        if (height.length < 3) return 0;

        int i, result = 0, length = height.length;

        int[] L = new int[length], R = new int[length];

        // 记录每个挡板的左/右边的最高挡板高度
        for (i = 1; i < length; i++) {
            L[i] = Math.max(L[i-1], height[i-1]);
            R[length - 1 - i] = Math.max(R[length-i], height[length-i]);
        }

        // 计算每个坐标处的垂直积水
        for (i = 0; i < length; i++) {
            if (L[i] > height[i] && R[i] > height[i]) {
                result += Math.min(L[i], R[i]) - height[i];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
//        int[] height = {5,4,1,2};

        Solution42 s = new Solution42();
        s.trap(height);
    }
}
