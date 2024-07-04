package io.github.spannm.leetcode.lc0.lc0900;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.*;

/**
 * 928. Minimize Malware Spread II.
 */
class Problem0928 extends LeetcodeProblem {

    private int[] p;
    private int[] size;

    int minMalwareSpread(int[][] _graph, int[] _initial) {
        int n = _graph.length;
        p = new int[n];
        size = new int[n];
        for (int i = 0; i < n; i++) {
            p[i] = i;
            size[i] = 1;
        }
        boolean[] clean = new boolean[n];
        Arrays.fill(clean, true);
        for (int i : _initial) {
            clean[i] = false;
        }
        for (int i = 0; i < n; i++) {
            if (!clean[i]) {
                continue;
            }
            for (int j = i + 1; j < n; j++) {
                if (clean[j] && _graph[i][j] == 1) {
                    union(i, j);
                }
            }
        }
        int[] cnt = new int[n];
        Map<Integer, Set<Integer>> mp = new HashMap<>();
        for (int i : _initial) {
            Set<Integer> s = new HashSet<>();
            for (int j = 0; j < n; j++) {
                if (clean[j] && _graph[i][j] == 1) {
                    s.add(find(j));
                }
            }
            for (int root : s) {
                cnt[root] += 1;
            }
            mp.put(i, s);
        }
        int mx = -1;
        int ans = 0;
        for (Map.Entry<Integer, Set<Integer>> entry : mp.entrySet()) {
            int i = entry.getKey();
            int t = 0;
            for (int root : entry.getValue()) {
                if (cnt[root] == 1) {
                    t += size[root];
                }
            }
            if (mx < t || mx == t && i < ans) {
                mx = t;
                ans = i;
            }
        }
        return ans;
    }

    private int find(int _x) {
        if (p[_x] != _x) {
            p[_x] = find(p[_x]);
        }
        return p[_x];
    }

    private void union(int _a, int _b) {
        int pa = find(_a);
        int pb = find(_b);
        if (pa != pb) {
            size[pb] += size[pa];
            p[pa] = pb;
        }
    }

}
