package io.github.spannm.leetcode.lc0.lc0200;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/summary-ranges/">228. Summary Ranges</a>.
 */
class Problem0228 extends LeetcodeProblem {

    List<String> summaryRanges(int[] _nums) {
        final int len = _nums.length;
        if (len == 0) {
            return List.of();
        }
        int rangeBegin = _nums[0];
        if (len == 1) {
            return List.of(Integer.toString(rangeBegin));
        }

        final List<String> ranges = new ArrayList<>();
        for (int i = 1; i < len; i++) {
            if (_nums[i] > _nums[i - 1] + 1) {
                int rangeEnd = _nums[i - 1];
                if (rangeBegin == rangeEnd) {
                    ranges.add(Integer.toString(rangeBegin));
                } else {
                    ranges.add(rangeBegin + "->" + rangeEnd);
                }
                rangeBegin = _nums[i];
            }
            if (i == len - 1) {
                int rangeEnd = _nums[i];
                if (rangeBegin == rangeEnd) {
                    ranges.add(Integer.toString(rangeBegin));
                } else {
                    ranges.add(rangeBegin + "->" + rangeEnd);
                }
            }
        }
        return ranges;
    }

}
