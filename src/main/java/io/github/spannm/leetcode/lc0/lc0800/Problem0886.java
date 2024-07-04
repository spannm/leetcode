package io.github.spannm.leetcode.lc0.lc0800;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 886. Possible Bipartition.
 */
class Problem0886 extends LeetcodeProblem {

    private int[] p;

    boolean possibleBipartition(int _n, int[][] _dislikes) {
        p = new int[_n];
        @SuppressWarnings("unchecked")
        List<Integer>[] g = new List[_n];
        Arrays.setAll(g, k -> new ArrayList<>());
        for (int i = 0; i < _n; i++) {
            p[i] = i;
        }
        for (var e : _dislikes) {
            int a = e[0] - 1;
            int b = e[1] - 1;
            g[a].add(b);
            g[b].add(a);
        }
        for (int i = 0; i < _n; i++) {
            for (int j : g[i]) {
                if (find(i) == find(j)) {
                    return false;
                }
                p[find(j)] = find(g[i].get(0));
            }
        }
        return true;
    }

    private int find(int _x) {
        if (p[_x] != _x) {
            p[_x] = find(p[_x]);
        }
        return p[_x];
    }

}
