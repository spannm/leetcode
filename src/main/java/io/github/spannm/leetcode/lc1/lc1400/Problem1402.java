package io.github.spannm.leetcode.lc1.lc1400;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/reducing-dishes/">1402. Reducing Dishes</a>.
 */
class Problem1402 extends LeetcodeProblem {

    static int maxSatisfaction(int[] _satisfaction) {
        Arrays.sort(_satisfaction);
        int presum = 0;
        int result = 0;
        for (int i = _satisfaction.length - 1; i >= 0; i--) {
            presum += _satisfaction[i];
            if (presum <= 0) {
                return result;
            }
            result += presum;
        }
        return result;
    }

}
