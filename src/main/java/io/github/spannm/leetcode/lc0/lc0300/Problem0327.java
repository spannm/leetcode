package io.github.spannm.leetcode.lc0.lc0300;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Arrays;

/**
 * 327. Count of Range Sum.
 */
class Problem0327 extends LeetcodeProblem {

    int countRangeSum(int[] _nums, int _lower, int _upper) {
        int n = _nums.length;
        long[] s = new long[n + 1];
        for (int i = 0; i < n; i++) {
            s[i + 1] = s[i] + _nums[i];
        }
        long[] arr = new long[n * 3 + 3];
        for (int i = 0, j = 0; i <= n; i++, j += 3) {
            arr[j] = s[i];
            arr[j + 1] = s[i] - _lower;
            arr[j + 2] = s[i] - _upper;
        }
        Arrays.sort(arr);
        int m = 0;
        for (int i = 0; i < arr.length; i++) {
            if (i == 0 || arr[i] != arr[i - 1]) {
                arr[m++] = arr[i];
            }
        }
        BinaryIndexedTree tree = new BinaryIndexedTree(m);
        int ans = 0;
        for (long x : s) {
            int l = search(arr, m, x - _upper);
            int r = search(arr, m, x - _lower);
            ans += tree.query(r) - tree.query(l - 1);
            tree.update(search(arr, m, x), 1);
        }
        return ans;
    }

    static int search(long[] _nums, int _r, long _x) {
        int l = 0;
        while (l < _r) {
            int mid = l + _r >> 1;
            if (_nums[mid] >= _x) {
                _r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l + 1;
    }

    static class BinaryIndexedTree {
        private final int   n;
        private final int[] c;

        BinaryIndexedTree(int _n) {
            n = _n;
            c = new int[_n + 1];
        }

        public void update(int _x, int _v) {
            while (_x <= n) {
                c[_x] += _v;
                _x += _x & -_x;
            }
        }

        public int query(int _x) {
            int s = 0;
            while (_x != 0) {
                s += c[_x];
                _x -= _x & -_x;
            }
            return s;
        }

    }

}
