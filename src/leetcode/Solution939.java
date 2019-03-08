package leetcode;

import java.util.*;


/**
 * Note:
 * 1. 不要笼统地全盘去考虑，最好从中间抽取一个点，考虑好情况后，再考虑边界情况。
 * 2. 不要想着先处理数据，再分析数据，通常做题是边处理边分析的，这样效率高。
 *      eg. 第一个for循环最后才将set添加进去。
 */
public class Solution939 {
    public int minAreaRect(int[][] points) {
        int dotCount = points.length;
        Arrays.sort(points, Comparator.comparingInt(a->a[0]));

        // 以x坐标为key，y坐标集合为value
        Map<Integer, Set<Integer>> dotMap = new HashMap<>();

        // 四边形面积
        int area = Integer.MAX_VALUE;
        // 遍历所有的点
        for (int i = 0; i < dotCount; i++) {
            Set<Integer> yCurSet = dotMap.getOrDefault(points[i][0], new HashSet<>());

            // 与之前遍历过的点做比较
            for (int j = 0; j < i; j++) {
                // 同x，跳过
                if (points[j][0] == points[i][0])
                    break;
                Set<Integer> yPreSet = dotMap.get(points[j][0]);

                // 取点的y集合中包含和本点同y的点 && 本点y集包含和取点同y的点
                if (yPreSet.contains(points[i][1]) && yCurSet.contains(points[j][1]))
                    area = Math.min(area, Math.abs((points[i][0] - points[j][0]) * (points[i][1] - points[j][1])));
            }

            yCurSet.add(points[i][1]);
            dotMap.put(points[i][0], yCurSet);
        }

        return area == Integer.MAX_VALUE ? 0 : area;
    }

    public static void main(String[] args) {
        int[][] points = {{1,1},{1,3},{3,1},{3,3},{2,2}};

        Solution939 s = new Solution939();
        s.minAreaRect(points);
    }
}