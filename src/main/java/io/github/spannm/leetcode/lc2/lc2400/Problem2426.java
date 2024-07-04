package io.github.spannm.leetcode.lc2.lc2400;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 2426. Number of Pairs Satisfying Inequality.
 */
class Problem2426 extends LeetcodeProblem {

    long numberOfPairs(int[] _nums1, int[] _nums2, int _diff) {
        BinaryIndexedTree tree = new BinaryIndexedTree(100000);
        long ans = 0;
        for (int i = 0; i < _nums1.length; i++) {
            int v = _nums1[i] - _nums2[i];
            ans += tree.query(v + _diff + 40000);
            tree.update(v + 40000, 1);
        }
        return ans;
    }

    static class BinaryIndexedTree {
        private final int   n;
        private final int[] c;

        BinaryIndexedTree(int _n) {
            n = _n;
            c = new int[_n + 1];
        }

        void update(int _x, int _delta) {
            while (_x <= n) {
                c[_x] += _delta;
                _x += lowbit(_x);
            }
        }

        int query(int _x) {
            int s = 0;
            while (_x > 0) {
                s += c[_x];
                _x -= lowbit(_x);
            }
            return s;
        }

        static int lowbit(int _x) {
            return _x & -_x;
        }

    }

}
