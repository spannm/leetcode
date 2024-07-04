package io.github.spannm.leetcode.lc3.lc3000;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 3005. Count Elements With Maximum Frequency.
 */
class Problem3005 extends LeetcodeProblem {

    int maxFrequencyElements(int[] _nums) {
        int[] counts = new int[101];
        for (int x : _nums) {
            counts[x]++;
        }
        int ans = 0;
        int mx = -1;
        for (int x : counts) {
            if (mx < x) {
                mx = x;
                ans = x;
            } else if (mx == x) {
                ans += x;
            }
        }
        return ans;
    }

}
