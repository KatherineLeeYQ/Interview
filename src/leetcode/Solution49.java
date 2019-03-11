package leetcode;

import java.util.*;

/**
 * 【字母异位词分组】
 */
public class Solution49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();

        for (int i = 0; i < strs.length; i++) {
            String curStr = strs[i];

            boolean consumed = false;
            for (int j = 0; j < res.size(); j++) {
                List<String> judge = res.get(j);

                String judgeStr = judge.get(0);
                char[] curCharArr = curStr.toCharArray();
                char[] judgeCharArr = judgeStr.toCharArray();
                Arrays.sort(curCharArr);
                Arrays.sort(judgeCharArr);
                if (String.valueOf(curCharArr).equals(String.valueOf(judgeCharArr))) {
                    consumed = true;
                    judge.add(curStr);
                }
            }

            if (!consumed) {
                List<String> newList = new ArrayList<>();
                newList.add(curStr);
                res.add(newList);
            }

        }

        return res;
    }

    public static void main(String[] args) {
        String[] arr = {"eat","tea","tan","ate","nat","bat"};

        Solution49 sss = new Solution49();
        sss.groupAnagrams(arr);
    }
}
