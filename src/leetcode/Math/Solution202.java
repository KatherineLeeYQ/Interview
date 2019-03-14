package leetcode.Math;

import java.util.HashSet;
import java.util.Set;

/**
 * [快乐数】
 * 对于一个正整数:
 * 每一次将该数替换为它每个位置上的数字的平方和
 * 重复这个过程直到这个数变为 1，也可能是无限循环但始终变不到 1
 * 如果可以变为 1，那么这个数就是快乐数
 *
 * Note1:
 * 不是快乐数的数称为不快乐数（unhappy number），所有不快乐数的数位平方和计算，
 * 最後都会进入 4 → 16 → 37 → 58 → 89 → 145 → 42 → 20 → 4 的循环中。
 *
 * Note2:
 * 两个思路，总之是要确定return false的条件：
 * 1. n出现重复值就一定是循环的
 * 2. 可以根据n值的特征，比如出现某个值就一定是循环的
 */
public class Solution202 {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        set.add(n);

        int value;
        while (n != 1) {
            value = 0;
            while (n != 0) {
                value += Math.pow(n % 10, 2);
                n = n / 10;
            }
            n = value;

            if (set.contains(n))
                return false;
            else
                set.add(n);
        }

        return true;
    }
}
