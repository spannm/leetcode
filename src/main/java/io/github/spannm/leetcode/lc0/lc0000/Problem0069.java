package io.github.spannm.leetcode.lc0.lc0000;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * <a href="https://leetcode.com/problems/sqrtx/">69. Sqrt(x)</a>.
 */
class Problem0069 extends LeetcodeProblem {

    int mySqrt(int _x) {
        long l = 0;
        long r = _x / 2 + 1;
        while (l <= r) {
            long mid = l + (r - l) / 2;
            long result = mid * mid;
            if (result == _x) {
                return (int) mid;
            } else if (result > _x) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return (int) r;
    }

}
