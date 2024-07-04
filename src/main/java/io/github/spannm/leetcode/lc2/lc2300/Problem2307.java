package io.github.spannm.leetcode.lc2.lc2300;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 2307. Check for Contradictions in Equations.
 */
class Problem2307 extends LeetcodeProblem {

    private int[]    p;
    private double[] w;

    boolean checkContradictions(List<List<String>> equations, double[] values) {
        Map<String, Integer> d = new HashMap<>();
        int n = 0;
        for (var e : equations) {
            for (var s : e) {
                if (!d.containsKey(s)) {
                    d.put(s, n++);
                }
            }
        }
        p = new int[n];
        w = new double[n];
        for (int i = 0; i < n; i++) {
            p[i] = i;
            w[i] = 1.0;
        }
        final double eps = 1e-5;
        for (int i = 0; i < equations.size(); i++) {
            int a = d.get(equations.get(i).get(0));
            int b = d.get(equations.get(i).get(1));
            int pa = find(a);
            int pb = find(b);
            double v = values[i];
            if (pa != pb) {
                p[pb] = pa;
                w[pb] = v * w[a] / w[b];
            } else if (Math.abs(v * w[a] - w[b]) >= eps) {
                return true;
            }
        }
        return false;
    }

    private int find(int x) {
        if (p[x] != x) {
            int root = find(p[x]);
            w[x] *= w[p[x]];
            p[x] = root;
        }
        return p[x];
    }

}
