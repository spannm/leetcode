package io.github.spannm.leetcode.lc2.lc2500;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.*;

/**
 * 2508. Add Edges to Make Degrees of All Nodes Even.
 */
class Problem2508 extends LeetcodeProblem {

    boolean isPossible(int n, List<List<Integer>> edges) {
        @SuppressWarnings("unchecked")
        Set<Integer>[] g = new Set[n + 1];
        Arrays.setAll(g, k -> new HashSet<>());
        for (var e : edges) {
            int a = e.get(0);
            int b = e.get(1);
            g[a].add(b);
            g[b].add(a);
        }
        List<Integer> vs = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (g[i].size() % 2 == 1) {
                vs.add(i);
            }
        }
        if (vs.isEmpty()) {
            return true;
        }
        if (vs.size() == 2) {
            int a = vs.get(0);
            int b = vs.get(1);
            if (!g[a].contains(b)) {
                return true;
            }
            for (int c = 1; c <= n; c++) {
                if (a != c && b != c && !g[a].contains(c) && !g[c].contains(b)) {
                    return true;
                }
            }
            return false;
        }
        if (vs.size() == 4) {
            int a = vs.get(0);
            int b = vs.get(1);
            int c = vs.get(2);
            int d = vs.get(3);
            if (!g[a].contains(b) && !g[c].contains(d) || !g[a].contains(c) && !g[b].contains(d)) {
                return true;
            }
            return !g[a].contains(d) && !g[b].contains(c);
        }
        return false;
    }

}
