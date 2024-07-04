package io.github.spannm.leetcode.lc1.lc1300;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Arrays;
import java.util.IdentityHashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/the-k-weakest-rows-in-a-matrix/">1337. The K Weakest Rows in a Matrix</a>.
 */
class Problem1337 extends LeetcodeProblem {

    int[] kWeakestRows(int[][] _matrix, final int _k) {
        Map<int[], Integer> map = new IdentityHashMap<>();
        for (int r = 0; r < _matrix.length; r++) {
            map.put(_matrix[r], r);
        }

        Arrays.sort(_matrix, Arrays::compare);

        final int[] results = new int[_k];
        for (int i = 0; i < _k; i++) {
            results[i] = map.get(_matrix[i]);
        }

        _matrix = null;
        map.clear();
        map = null;

        return results;
    }

}
