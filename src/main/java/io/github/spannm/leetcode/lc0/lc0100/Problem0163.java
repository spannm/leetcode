package io.github.spannm.leetcode.lc0.lc0100;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/missing-ranges">163. Missing Ranges</a>.
 */
class Problem0163 extends LeetcodeProblem {

    List<String> findMissingRanges(int[] _nums, int _lower, int _upper) {
        List<String> result = new ArrayList<>();
        long low = (long) _lower - 1;
        long up = 0;
        for (int i = 0; i <= _nums.length; i++) {
            if (i == _nums.length) {
                up = (long) _upper + 1;
            } else {
                up = _nums[i];
            }
            if (up == low + 2) {
                result.add(low + 1 + "");
            } else if (up > low + 2) {
                result.add(low + 1 + "->" + (up - 1));
            }
            low = up;
        }
        return result;
    }

}
