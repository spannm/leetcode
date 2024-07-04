package io.github.spannm.leetcode.lc1.lc1200;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 1272. Remove Interval.
 */
class Problem1272 extends LeetcodeProblem {

    List<List<Integer>> removeInterval(int[][] _intervals, int[] _toBeRemoved) {
        int x = _toBeRemoved[0];
        int y = _toBeRemoved[1];
        List<List<Integer>> ans = new ArrayList<>();
        for (var e : _intervals) {
            int a = e[0];
            int b = e[1];
            if (a >= y || b <= x) {
                ans.add(Arrays.asList(a, b));
            } else {
                if (a < x) {
                    ans.add(Arrays.asList(a, x));
                }
                if (b > y) {
                    ans.add(Arrays.asList(y, b));
                }
            }
        }
        return ans;
    }

}
