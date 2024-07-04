package io.github.spannm.leetcode.lc2.lc2100;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.ArrayList;
import java.util.List;

/**
 * 2100. Find Good Days to Rob the Bank.
 */
class Problem2100 extends LeetcodeProblem {

    List<Integer> goodDaysToRobBank(int[] security, int time) {
        int n = security.length;
        if (n <= time * 2) {
            return List.of();
        }
        int[] left = new int[n];
        int[] right = new int[n];
        for (int i = 1; i < n; i++) {
            if (security[i] <= security[i - 1]) {
                left[i] = left[i - 1] + 1;
            }
        }
        for (int i = n - 2; i >= 0; i--) {
            if (security[i] <= security[i + 1]) {
                right[i] = right[i + 1] + 1;
            }
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = time; i < n - time; i++) {
            if (time <= Math.min(left[i], right[i])) {
                ans.add(i);
            }
        }
        return ans;
    }

}
