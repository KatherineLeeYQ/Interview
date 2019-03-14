package leetcode.Math;

/**
 * 【斐波那契数】
 * Note:
 * 备忘录思想，将已经计算的数存起来，避免重复计算浪费时间。
 */
public class Solution509 {
    public int fib(int N) {
        // 注意边界条件
        if (N < 2)
            return N;

        int[] Fib = new int[N + 1];
        Fib[0] = 0;
        Fib[1] = 1;

        // 备忘录
        for (int i = 2; i <= N; ++i) {
            Fib[i] = Fib[i - 1] + Fib[i - 2];
        }

        return Fib[N];
    }
}
