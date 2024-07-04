package io.github.spannm.leetcode.lc2.lc2700;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.HashSet;
import java.util.Set;

/**
 * 2718. Sum of Matrix After Queries.
 */
class Problem2718 extends LeetcodeProblem {

    long matrixSumQueries(int n, int[][] queries) {
        Set<Integer> row = new HashSet<>();
        Set<Integer> col = new HashSet<>();
        int m = queries.length;
        long ans = 0;
        for (int k = m - 1; k >= 0; k--) {
            var q = queries[k];
            int t = q[0];
            int i = q[1];
            int v = q[2];
            if (t == 0) {
                if (row.add(i)) {
                    ans += 1L * (n - col.size()) * v;
                }
            } else {
                if (col.add(i)) {
                    ans += 1L * (n - row.size()) * v;
                }
            }
        }
        return ans;
    }

}
