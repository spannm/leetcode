package io.github.spannm.leetcode.lc1.lc1000;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/number-of-submatrices-that-sum-to-target/">1074. Number of Submatrices That
 * Sum to Target</a>.
 */
class Problem1074 extends LeetcodeProblem {

    int numSubmatrixSumTarget(int[][] _matrix, int _target) {
        int rows = _matrix.length;
        int cols = _matrix[0].length;
        int ans = 0;
        for (int r = 0; r < rows; r++) {
            int[] col = new int[cols];
            for (int r2 = r; r2 < rows; r2++) {
                for (int c = 0; c < cols; c++) {
                    col[c] += _matrix[r2][c];
                }
                ans += f(col, _target);
            }
        }
        return ans;
    }

    static int f(int[] _nums, int _target) {
        Map<Integer, Integer> d = new HashMap<>();
        d.put(0, 1);
        int s = 0;
        int cnt = 0;
        for (int x : _nums) {
            s += x;
            cnt += d.getOrDefault(s - _target, 0);
            d.merge(s, 1, Integer::sum);
        }
        return cnt;
    }

}
