package io.github.spannm.leetcode.lc2.lc2400;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Arrays;

/**
 * 2418. Sort the People.
 */
class Problem2418 extends LeetcodeProblem {

    String[] sortPeople(String[] names, int[] heights) {
        int n = names.length;
        Integer[] idx = new Integer[n];
        for (int i = 0; i < n; i++) {
            idx[i] = i;
        }
        Arrays.sort(idx, (i, j) -> heights[j] - heights[i]);
        String[] ans = new String[n];
        for (int i = 0; i < n; i++) {
            ans[i] = names[idx[i]];
        }
        return ans;
    }

}
