package io.github.spannm.leetcode.lc0.lc0900;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 924. Minimize Malware Spread.
 */
class Problem0924 extends LeetcodeProblem {

    int minMalwareSpread(int[][] _graph, int[] _initial) {
        int len = _graph.length;
        int[] p = new int[len];
        for (int i = 0; i < len; i++) {
            p[i] = i;
        }
        int[] size = new int[len];
        Arrays.fill(size, 1);
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if (_graph[i][j] == 1) {
                    int pa = find(i, p);
                    int pb = find(j, p);
                    if (pa == pb) {
                        continue;
                    }
                    p[pa] = pb;
                    size[pb] += size[pa];
                }
            }
        }
        int mi = Integer.MAX_VALUE;
        int res = _initial[0];
        Arrays.sort(_initial);
        for (int i = 0; i < _initial.length; i++) {
            int t = 0;
            Set<Integer> s = new HashSet<>();
            for (int j = 0; j < _initial.length; j++) {
                if (i == j || s.contains(find(_initial[j], p))) {
                    continue;
                }
                s.add(find(_initial[j], p));
                t += size[find(_initial[j], p)];
            }
            if (mi > t) {
                mi = t;
                res = _initial[i];
            }
        }
        return res;
    }

    static int find(int _x, int[] _p) {
        if (_p[_x] != _x) {
            _p[_x] = find(_p[_x], _p);
        }
        return _p[_x];
    }

}
