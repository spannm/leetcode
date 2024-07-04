package io.github.spannm.leetcode.lc2.lc2900;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 2924. Find Champion II.
 */
class Problem2924 extends LeetcodeProblem {

    int findChampion(int n, int[][] edges) {
        int[] indeg = new int[n];
        for (var e : edges) {
            indeg[e[1]]++;
        }
        int ans = -1;
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (indeg[i] == 0) {
                cnt++;
                ans = i;
            }
        }
        return cnt == 1 ? ans : -1;
    }

}
