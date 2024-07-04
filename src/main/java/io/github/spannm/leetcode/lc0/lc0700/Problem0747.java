package io.github.spannm.leetcode.lc0.lc0700;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/largest-number-at-least-twice-of-others/">747. Largest Number At Least Twice
 * of Others</a>.
 */
class Problem0747 extends LeetcodeProblem {

    int dominantIndex(int[] _nums) {
        final int len = _nums.length;
        Map<Integer, Integer> map = new HashMap<>(len);
        for (int i = 0; i < len; i++) {
            map.put(_nums[i], i);
        }
        Arrays.sort(_nums);
        int max = _nums[len - 1];
        int secondMax = _nums[len - 2];
        return max >= 2 * secondMax ? map.get(max) : -1;
    }

}
