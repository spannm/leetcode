package io.github.spannm.leetcode.lc1.lc1800;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * <a href="https://leetcode.com/problems/largest-color-value-in-a-directed-graph/"> 1822. Sign of the Product of an
 * Array</a>.
 */
class Problem1822 extends LeetcodeProblem {

    int arraySign(int[] _nums) {
        int sign = 1;
        for (int num : _nums) {
            if (num < 0) {
                sign *= -1;
            } else if (num == 0) {
                return 0;
            }
        }
        return sign;
    }

}
