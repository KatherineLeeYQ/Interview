package leetcode.Array;

import java.util.*;

/**
 * 【组合总和】
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * candidates 中的数字可以无限制重复被选取。
 *
 * Note：
 * 回溯算法：递归 & 非递归
 */
public class Solution39 {
    // 递归回溯
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        // 排序之后操作，可避免重复计算
        Arrays.sort(candidates);
        List<List<Integer>> listAll = new ArrayList<>();
        List<Integer> list = new ArrayList<>();

        // 递归
        find(listAll,list,candidates,target,0);
        return listAll;
    }
    public void find(List<List<Integer>> listAll, List<Integer> tmp, int[] candidates, int target, int index){
        // 递归终止条件
        if(target == 0){
            listAll.add(tmp);
            return;
        }
        if(target < candidates[0]) return;
        for(int i = index; i < candidates.length && candidates[i] <= target; i++){
            List<Integer> list = new ArrayList<>(tmp); // 深拷贝
            list.add(candidates[i]);

            //递归运算，将i传递至下一次运算是为了避免结果重复。
            find(listAll, list, candidates,target - candidates[i], i);
        }
    }

    // 非递归回溯
    public List<List<Integer>> combinationSum1(int[] candidates, int target) {
        // 排序之后操作，可避免重复计算
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();

        int len = candidates.length;
        for (int i = 0; i < len; i++) {
            LinkedList<Integer> curList = new LinkedList<>();
            Map<Integer, Integer> indexMap = new HashMap<>();
            int rest = target;
            int curIndex = i;
            int curLevel = 0;

            while (curIndex < len) {
                rest -= candidates[curIndex];
                curList.add(candidates[curIndex]);
                indexMap.put(++curLevel, curIndex);

                if (rest == 0)
                    res.add(new ArrayList<>(curList));
                // 非递归回溯
                if (rest <= 0) {
                    curLevel = curList.size();
                    indexMap.put(curLevel, len - 1);

                    while (indexMap.size() > 0 && indexMap.get(curLevel) == len - 1) {
                        rest += curList.removeLast();
                        indexMap.remove(curLevel--);
                    }

                    if (curList.size() <= 1)
                        break;
                    else {
                        rest += curList.removeLast();
                        curIndex = indexMap.get(curLevel) + 1;
                        indexMap.remove(curLevel);
                        curLevel--;
                    }
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
//        int[] candidates = {7,3};//17
//        int[] candidates = {2,3,5};//8
        int[] candidates = {2,3,6,7};//7

        Solution39 s = new Solution39();
        s.combinationSum(candidates, 7);
    }
}
