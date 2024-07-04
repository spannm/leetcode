package io.github.spannm.leetcode.lc1.lc1000;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 1042. Flower Planting With No Adjacent.
 */
class Problem1042 extends LeetcodeProblem {

    int[] gardenNoAdj(int _n, int[][] _paths) {
        @SuppressWarnings("unchecked")
        List<Integer>[] g = new List[_n];
        Arrays.setAll(g, k -> new ArrayList<>());
        for (var p : _paths) {
            int x = p[0] - 1;
            int y = p[1] - 1;
            g[x].add(y);
            g[y].add(x);
        }
        int[] ans = new int[_n];
        boolean[] used = new boolean[5];
        for (int x = 0; x < _n; x++) {
            Arrays.fill(used, false);
            for (int y : g[x]) {
                used[ans[y]] = true;
            }
            for (int c = 1; c < 5; c++) {
                if (!used[c]) {
                    ans[x] = c;
                    break;
                }
            }
        }
        return ans;
    }

}
