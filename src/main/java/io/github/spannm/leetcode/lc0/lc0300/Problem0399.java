package io.github.spannm.leetcode.lc0.lc0300;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.*;

/**
 * <a href="https://leetcode.com/problems/evaluate-division/">399. Evaluate Division</a>.
 */
class Problem0399 extends LeetcodeProblem {

    static double[] calcEquation(List<List<String>> _equations, double[] _values, List<List<String>> _queries) {
        final int esz = _equations.size();
        final int qsz = _queries.size();
        final Map<String, List<Pair>> graph = new HashMap<>();
        final double[] qAnswers = new double[qsz];

        for (int i = 0; i < esz; i++) {
            String u = _equations.get(i).get(0);
            String v = _equations.get(i).get(1);
            double w = _values[i];
            graph.computeIfAbsent(u, k -> new ArrayList<>());
            graph.computeIfAbsent(v, k -> new ArrayList<>());
            graph.get(u).add(new Pair(v, w));
            graph.get(v).add(new Pair(u, 1 / w));
        }

        for (int i = 0; i < qsz; i++) {
            String u = _queries.get(i).get(0);
            String v = _queries.get(i).get(1);
            double q = graph.containsKey(u) ? dfs(u, v, new HashSet<>(), graph) : -1.0;
            qAnswers[i] = q;
        }

        return qAnswers;
    }

    static double dfs(final String _source,
        final String _dest,
        final Set<String> _vis,
        final Map<String, List<Pair>> _graph) {

        _vis.add(_source);
        if (_source.equals(_dest)) {
            return 1;
        }

        for (Pair e : _graph.get(_source)) {
            if (!_vis.contains(e.v)) {
                double ret = dfs(e.v, _dest, _vis, _graph);
                if (ret > 0) {
                    return e.w * ret;
                }
            }
        }
        return -1.0d;
    }

    static final class Pair {
        private final String v;
        private final double w;

        Pair(String _v, double _w) {
            v = _v;
            w = _w;
        }
    }

}
