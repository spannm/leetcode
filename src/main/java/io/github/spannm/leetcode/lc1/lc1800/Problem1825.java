package io.github.spannm.leetcode.lc1.lc1800;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.TreeMap;

class Problem1825 extends LeetcodeProblem {

    static class MKAverage {

        private final int                       m;
        private final int                       k;
        private long                            s;
        private int                             size1;
        private int                             size3;
        private final Deque<Integer>            q   = new ArrayDeque<>();
        private final TreeMap<Integer, Integer> lo  = new TreeMap<>();
        private final TreeMap<Integer, Integer> mid = new TreeMap<>();
        private final TreeMap<Integer, Integer> hi  = new TreeMap<>();

        MKAverage(int _m, int _k) {
            m = _m;
            k = _k;
        }

        void addElement(int _num) {
            if (lo.isEmpty() || _num <= lo.lastKey()) {
                lo.merge(_num, 1, Integer::sum);
                size1++;
            } else if (hi.isEmpty() || _num >= hi.firstKey()) {
                hi.merge(_num, 1, Integer::sum);
                size3++;
            } else {
                mid.merge(_num, 1, Integer::sum);
                s += _num;
            }
            q.offer(_num);
            if (q.size() > m) {
                int x = q.poll();
                if (lo.containsKey(x)) {
                    if (lo.merge(x, -1, Integer::sum) == 0) {
                        lo.remove(x);
                    }
                    size1--;
                } else if (hi.containsKey(x)) {
                    if (hi.merge(x, -1, Integer::sum) == 0) {
                        hi.remove(x);
                    }
                    size3--;
                } else {
                    if (mid.merge(x, -1, Integer::sum) == 0) {
                        mid.remove(x);
                    }
                    s -= x;
                }
            }
            for (; size1 > k; --size1) {
                int x = lo.lastKey();
                if (lo.merge(x, -1, Integer::sum) == 0) {
                    lo.remove(x);
                }
                mid.merge(x, 1, Integer::sum);
                s += x;
            }
            for (; size3 > k; --size3) {
                int x = hi.firstKey();
                if (hi.merge(x, -1, Integer::sum) == 0) {
                    hi.remove(x);
                }
                mid.merge(x, 1, Integer::sum);
                s += x;
            }
            for (; size1 < k && !mid.isEmpty(); ++size1) {
                int x = mid.firstKey();
                if (mid.merge(x, -1, Integer::sum) == 0) {
                    mid.remove(x);
                }
                s -= x;
                lo.merge(x, 1, Integer::sum);
            }
            for (; size3 < k && !mid.isEmpty(); ++size3) {
                int x = mid.lastKey();
                if (mid.merge(x, -1, Integer::sum) == 0) {
                    mid.remove(x);
                }
                s -= x;
                hi.merge(x, 1, Integer::sum);
            }
        }

        public int calculateMKAverage() {
            return q.size() < m ? -1 : (int) (s / (q.size() - k * 2));
        }

    }

}
