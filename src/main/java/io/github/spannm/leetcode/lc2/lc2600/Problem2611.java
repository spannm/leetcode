package io.github.spannm.leetcode.lc2.lc2600;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Arrays;

/**
 * 2611. Mice and Cheese.
 */
class Problem2611 extends LeetcodeProblem {

    int miceAndCheese(int[] reward1, int[] reward2, int k) {
        int n = reward1.length;
        Integer[] idx = new Integer[n];
        for (int i = 0; i < n; i++) {
            idx[i] = i;
        }
        Arrays.sort(idx, (i, j) -> reward1[j] - reward2[j] - (reward1[i] - reward2[i]));
        int ans = 0;
        for (int i = 0; i < k; i++) {
            ans += reward1[idx[i]];
        }
        for (int i = k; i < n; i++) {
            ans += reward2[idx[i]];
        }
        return ans;
    }

}
