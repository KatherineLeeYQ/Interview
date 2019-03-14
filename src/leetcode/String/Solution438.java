package leetcode.String;

import java.util.*;

/**
 * 【找到字符串中所有字母异位词】
 */
public class Solution438 {
    public List<Integer> findAnagrams(String s, String p) {
        int tLength = p.length();
        List<Integer> res = new ArrayList<>();

        char[] pc = p.toCharArray();
        Arrays.sort(pc);
        String newP = String.valueOf(pc);

        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < s.length() - tLength + 1; i++) {
            char[] sc = s.substring(i, i + tLength).toCharArray();
            Arrays.sort(sc);
            String subStr = String.valueOf(sc);

            if (subStr.equals(newP))
                ans.add(i);
        }

        return res;
    }

    public static void main(String[] args) {
        String s = "cbaebabacd";
        String p = "abc";

        Solution438 ss = new Solution438();
        ss.findAnagrams(s, p);
    }
}
