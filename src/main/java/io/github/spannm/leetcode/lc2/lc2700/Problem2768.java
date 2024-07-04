package io.github.spannm.leetcode.lc2.lc2700;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.HashMap;
import java.util.Map;

/**
 * 2768. Number of Black Blocks.
 */
class Problem2768 extends LeetcodeProblem {

    long[] countBlackBlocks(int m, int n, int[][] coordinates) {
        Map<Long, Integer> cnt = new HashMap<>(coordinates.length);
        int[] dirs = {0, 0, -1, -1, 0};
        for (var e : coordinates) {
            int x = e[0];
            int y = e[1];
            for (int k = 0; k < 4; k++) {
                int i = x + dirs[k];
                int j = y + dirs[k + 1];
                if (i >= 0 && i < m - 1 && j >= 0 && j < n - 1) {
                    cnt.merge(1L * i * n + j, 1, Integer::sum);
                }
            }
        }
        long[] ans = new long[5];
        ans[0] = (m - 1L) * (n - 1);
        for (int x : cnt.values()) {
            ans[x]++;
            ans[0]--;
        }
        return ans;
    }

}
