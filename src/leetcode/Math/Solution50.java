package leetcode.Math;

/**
 * 【Pow(x, n) 】
 * Note:
 * 不要直接用for循环去算，会超时。
 * 使用二分的方法。
 */
public class Solution50 {
    public double myPow(double x, int n) {
        if (n == 0) return 1;

        double t = myPow(x, n/2);
        if (n%2 != 0)
            return n < 0 ? t*t/x : t*t*x;// 此处考虑了负数倒置
        else
            return t*t;
    }
}
