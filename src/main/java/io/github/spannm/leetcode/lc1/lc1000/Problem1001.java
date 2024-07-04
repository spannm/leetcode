package io.github.spannm.leetcode.lc1.lc1000;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * <a href="https://leetcode.com/problems/grid-illumination/">1001. Grid Illumination</a>.
 */
class Problem1001 extends LeetcodeProblem {

    int[] gridIllumination(int _n, int[][] _lamps, int[][] _queries) {
        Set<Long> s = new HashSet<>();
        Map<Integer, Integer> row = new HashMap<>();
        Map<Integer, Integer> col = new HashMap<>();
        Map<Integer, Integer> diag1 = new HashMap<>();
        Map<Integer, Integer> diag2 = new HashMap<>();
        for (var lamp : _lamps) {
            int i = lamp[0];
            int j = lamp[1];
            if (s.add(func(-1, i, j))) {
                merge(row, i, 1);
                merge(col, j, 1);
                merge(diag1, i - j, 1);
                merge(diag2, i + j, 1);
            }
        }
        int m = _queries.length;
        int[] ans = new int[m];
        for (int k = 0; k < m; k++) {
            int i = _queries[k][0];
            int j = _queries[k][1];
            if (row.getOrDefault(i, 0) > 0 || col.getOrDefault(j, 0) > 0 || diag1.getOrDefault(i - j, 0) > 0 || diag2.getOrDefault(i + j, 0) > 0) {
                ans[k] = 1;
            }
            for (int x = i - 1; x <= i + 1; x++) {
                for (int y = j - 1; y <= j + 1; y++) {
                    if (x < 0 || x >= _n || y < 0 || y >= _n || !s.contains(func(_n, x, y))) {
                        continue;
                    }
                    s.remove(func(_n, x, y));
                    merge(row, x, -1);
                    merge(col, y, -1);
                    merge(diag1, x - y, -1);
                    merge(diag2, x + y, -1);
                }
            }
        }
        return ans;
    }

    static void merge(Map<Integer, Integer> _counts, int _x, int _d) {
        if (_counts.merge(_x, _d, Integer::sum) == 0) {
            _counts.remove(_x);
        }
    }

    static long func(int _n, long _i, long _j) {
        return _i * _n + _j;
    }

}
