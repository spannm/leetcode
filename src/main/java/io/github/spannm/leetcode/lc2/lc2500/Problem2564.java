package io.github.spannm.leetcode.lc2.lc2500;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.HashMap;
import java.util.Map;

/**
 * 2564. Substring XOR Queries.
 */
class Problem2564 extends LeetcodeProblem {

    int[][] substringXorQueries(String s, int[][] queries) {
        Map<Integer, int[]> d = new HashMap<>();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            int x = 0;
            for (int j = 0; j < 32 && i + j < n; j++) {
                x = x << 1 | s.charAt(i + j) - '0';
                d.putIfAbsent(x, new int[] {i, i + j});
                if (x == 0) {
                    break;
                }
            }
        }
        int m = queries.length;
        int[][] ans = new int[m][2];
        for (int i = 0; i < m; i++) {
            int first = queries[i][0];
            int second = queries[i][1];
            int val = first ^ second;
            ans[i] = d.getOrDefault(val, new int[] {-1, -1});
        }
        return ans;
    }

}
