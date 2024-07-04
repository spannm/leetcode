package io.github.spannm.leetcode.lc2.lc2000;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 2031. Count Subarrays With More Ones Than Zeros.
 */
class Problem2031 extends LeetcodeProblem {

    private static final int MOD = (int) 1e9 + 7;

    int subarraysWithMoreZerosThanOnes(int[] _nums) {
        int n = _nums.length;
        int[] s = new int[n + 1];
        for (int i = 0; i < n; i++) {
            s[i + 1] = s[i] + (_nums[i] == 1 ? 1 : -1);
        }
        BinaryIndexedTree tree = new BinaryIndexedTree(n + 1);
        int ans = 0;
        for (int v : s) {
            ans = (ans + tree.query(v - 1)) % MOD;
            tree.update(v, 1);
        }
        return ans;
    }

    static class BinaryIndexedTree {
        private final int   n;
        private final int[] c;

        BinaryIndexedTree(int _n) {
            _n += (int) 1e5 + 1;
            n = _n;
            c = new int[_n + 1];
        }

        void update(int _x, int _delta) {
            _x += (int) 1e5 + 1;
            while (_x <= n) {
                c[_x] += _delta;
                _x += lowbit(_x);
            }
        }

        int query(int _x) {
            _x += (int) 1e5 + 1;
            int s = 0;
            while (_x > 0) {
                s += c[_x];
                _x -= lowbit(_x);
            }
            return s;
        }

        static int lowbit(int _x) {
            _x += (int) 1e5 + 1;
            return _x & -_x;
        }

    }

}
