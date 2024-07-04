package io.github.spannm.leetcode.lc2.lc2600;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 2655. Find Maximal Uncovered Ranges.
 */
class Problem2655 extends LeetcodeProblem {

    int[][] findMaximalUncoveredRanges(int n, int[][] ranges) {
        Arrays.sort(ranges, Comparator.comparingInt(a -> a[0]));
        int last = -1;
        List<int[]> ans = new ArrayList<>();
        for (int[] range : ranges) {
            int l = range[0];
            int r = range[1];
            if (last + 1 < l) {
                ans.add(new int[] {last + 1, l - 1});
            }
            last = Math.max(last, r);
        }
        if (last + 1 < n) {
            ans.add(new int[] {last + 1, n - 1});
        }
        return ans.toArray(new int[0][]);
    }

}
