package io.github.spannm.leetcode.lc2.lc2000;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * 2077. Paths in Maze That Lead to Same Room.
 */
class Problem2077 extends LeetcodeProblem {

    int numberOfPaths(int _n, int[][] _corridors) {
        @SuppressWarnings("unchecked")
        Set<Integer>[] g = new Set[_n + 1];
        for (int i = 0; i <= _n; i++) {
            g[i] = new HashSet<>();
        }
        for (var c : _corridors) {
            int a = c[0];
            int b = c[1];
            g[a].add(b);
            g[b].add(a);
        }
        int ans = 0;
        for (int c = 1; c <= _n; c++) {
            var nxt = new ArrayList<>(g[c]);
            int m = nxt.size();
            for (int i = 0; i < m; i++) {
                for (int j = i + 1; j < m; j++) {
                    int a = nxt.get(i);
                    int b = nxt.get(j);
                    if (g[b].contains(a)) {
                        ans++;
                    }
                }
            }
        }
        return ans / 3;
    }

}
