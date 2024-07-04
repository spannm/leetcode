package io.github.spannm.leetcode.lc1.lc1000;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.HashMap;
import java.util.Map;

/**
 * 1072. Flip Columns For Maximum Number of Equal Rows.
 */
class Problem1072 extends LeetcodeProblem {

    int maxEqualRowsAfterFlips(int[][] _matrix) {
        Map<String, Integer> counts = new HashMap<>();
        int ans = 0;
        int n = _matrix[0].length;
        for (var row : _matrix) {
            char[] cs = new char[n];
            for (int i = 0; i < n; i++) {
                cs[i] = (char) (row[0] ^ row[i]);
            }
            ans = Math.max(ans, counts.merge(String.valueOf(cs), 1, Integer::sum));
        }
        return ans;
    }

}
