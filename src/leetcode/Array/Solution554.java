package leetcode.Array;

import java.util.*;

/**
 * 【砖墙】
 */
public class Solution554 {
    public int leastBricks(List<List<Integer>> wall) {
        int rowCount = wall.size(); // 有多少行
        int itemCount = 0;          // 每行有多少个元素
        int throughRow = 0;         // 记录每个分割线可以通过多少行
        int minCut = rowCount;

        int width = 0;
        for (Integer item: wall.get(0)) {
            width += item;
        }

        Set<Integer> lineSet = new HashSet<>();// 有意义的分割线
        // 对所有的行，遍历
        for (int i = 0; i < rowCount; i++) {
            itemCount = wall.get(i).size();

            // 对行内所有元素，遍历
            int currentWidth = 0;
            for (int j = 0; j < itemCount - 1; j++) {
                currentWidth += wall.get(i).get(j);

                lineSet.add(currentWidth);
            }
        }

        // 对于每一条有意义的分割线，遍历
        Iterator<Integer> it = lineSet.iterator();
        while (it.hasNext()) {
            int l = it.next();
            throughRow = 0;

            // 对所有的行，遍历
            for (int i = 0; i < rowCount; i++) {
                itemCount = wall.get(i).size();

                // 对行内所有元素，遍历
                int currentWidth = 0;
                for (int j = 0; j < itemCount; j++) {
                    currentWidth += wall.get(i).get(j);

                    if (l > currentWidth)
                        continue;
                    else if (l < currentWidth)
                        break;
                    else {
                        throughRow += 1;
                        break;
                    }
                }
            }

            // 如果可以穿透所有行，那么直接返回，不用再计算了
            if (throughRow == rowCount)
                return 0;

            // 遍历至今，最小经过层数
            minCut = Math.min(minCut, rowCount - throughRow);
        }

        return minCut;
    }

    public static void main(String[] args) {
        List<List<Integer>> wall = Arrays.asList(
                Arrays.asList(1,2,2,1),
                Arrays.asList(3,1,2),
                Arrays.asList(1,3,2),
                Arrays.asList(2,4),
                Arrays.asList(3,1,2),
                Arrays.asList(1,3,1,1));

//        List<List<Integer>> wall = Arrays.asList(
//                Arrays.asList(1,1),
//                Arrays.asList(1,1),
//                Arrays.asList(1,1));

        Solution554 s = new Solution554();
        s.leastBricks(wall);
    }
}
