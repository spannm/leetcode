package io.github.spannm.leetcode.lc2.lc2300;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 2374. Node With Highest Edge Score.
 */
class Problem2374 extends LeetcodeProblem {

    int edgeScore(int[] edges) {
        int n = edges.length;
        long[] cnt = new long[n];
        for (int i = 0; i < n; i++) {
            cnt[edges[i]] += i;
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (cnt[ans] < cnt[i]) {
                ans = i;
            }
        }
        return ans;
    }

}
