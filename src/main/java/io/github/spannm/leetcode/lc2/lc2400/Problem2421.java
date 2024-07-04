package io.github.spannm.leetcode.lc2.lc2400;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.*;

/**
 * 2421. Number of Good Paths.
 */
class Problem2421 extends LeetcodeProblem {

    private int[] p;

    int numberOfGoodPaths(int[] _vals, int[][] _edges) {
        int n = _vals.length;
        p = new int[n];
        int[][] arr = new int[n][2];
        @SuppressWarnings("unchecked")
        List<Integer>[] g = new List[n];
        Arrays.setAll(g, k -> new ArrayList<>());
        for (int[] e : _edges) {
            int a = e[0];
            int b = e[1];
            g[a].add(b);
            g[b].add(a);
        }
        Map<Integer, Map<Integer, Integer>> size = new HashMap<>();
        for (int i = 0; i < n; i++) {
            p[i] = i;
            arr[i] = new int[] {_vals[i], i};
            size.computeIfAbsent(i, k -> new HashMap<>()).put(_vals[i], 1);
        }
        Arrays.sort(arr, Comparator.comparingInt(a -> a[0]));
        int ans = n;
        for (var e : arr) {
            int v = e[0];
            int a = e[1];
            for (int b : g[a]) {
                if (_vals[b] > v) {
                    continue;
                }
                int pa = find(a);
                int pb = find(b);
                if (pa != pb) {
                    ans += size.get(pa).getOrDefault(v, 0) * size.get(pb).getOrDefault(v, 0);
                    p[pa] = pb;
                    size.get(pb).put(
                        v, size.get(pb).getOrDefault(v, 0) + size.get(pa).getOrDefault(v, 0));
                }
            }
        }
        return ans;
    }

    private int find(int x) {
        if (p[x] != x) {
            p[x] = find(p[x]);
        }
        return p[x];
    }

}
