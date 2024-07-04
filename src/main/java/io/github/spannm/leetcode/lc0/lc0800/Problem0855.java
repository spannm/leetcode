package io.github.spannm.leetcode.lc0.lc0800;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

class Problem0855 extends LeetcodeProblem {

    static class ExamRoom {
        private final int                   n;
        private final TreeSet<int[]>        ts    = new TreeSet<>((a, b) -> {
                                                      int d1 = dist(a);
                                                      int d2 = dist(b);
                                                      return d1 == d2 ? a[0] - b[0] : d2 - d1;
                                                  });
        private final Map<Integer, Integer> left  = new HashMap<>();
        private final Map<Integer, Integer> right = new HashMap<>();

        ExamRoom(int _n) {
            n = _n;
            add(new int[] {-1, _n});
        }

        int seat() {
            int[] s = ts.first();
            int p = s[0] + s[1] >> 1;
            if (s[0] == -1) {
                p = 0;
            } else if (s[1] == n) {
                p = n - 1;
            }
            del(s);
            add(new int[] {s[0], p});
            add(new int[] {p, s[1]});
            return p;
        }

        void leave(int _p) {
            int l = left.get(_p);
            int r = right.get(_p);
            del(new int[] {l, _p});
            del(new int[] {_p, r});
            add(new int[] {l, r});
        }

        private int dist(int[] _s) {
            int l = _s[0];
            int r = _s[1];
            return l == -1 || r == n ? r - l - 1 : r - l >> 1;
        }

        private void add(int[] _s) {
            ts.add(_s);
            left.put(_s[1], _s[0]);
            right.put(_s[0], _s[1]);
        }

        private void del(int[] _s) {
            ts.remove(_s);
            left.remove(_s[1]);
            right.remove(_s[0]);
        }

    }

}
