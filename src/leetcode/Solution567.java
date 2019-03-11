package leetcode;

import java.util.Arrays;

/**
 * 【字符串的排列】：判断 s2 是否包含 s1 的排列
 */
public class Solution567 {
    public boolean checkInclusion(String s1, String s2) {
        int s1Len = s1.length();
        int s2Len = s2.length();

        char[] s1ca = s1.toCharArray();
        Arrays.sort(s1ca);
        s1 = String.valueOf(s1ca);

        for (int i = 0; i < s2Len - s1Len + 1; i++) {
            char[] ca = s2.substring(i, i + s1Len).toCharArray();
            Arrays.sort(ca);
            String curStr = String.valueOf(ca);

            if (curStr.equals(s1))
                return true;
        }

        return false;
    }

    public static void main(String[] args) {

    }
}
