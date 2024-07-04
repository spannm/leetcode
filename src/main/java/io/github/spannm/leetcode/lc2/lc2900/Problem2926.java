package io.github.spannm.leetcode.lc2.lc2900;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Arrays;

/**
 * 2926. Maximum Balanced Subsequence Sum.
 */
class Problem2926 extends LeetcodeProblem {

    long maxBalancedSubsequenceSum(int[] nums) {
        int n = nums.length;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = nums[i] - i;
        }
        Arrays.sort(arr);
        int m = 0;
        for (int i = 0; i < n; i++) {
            if (i == 0 || arr[i] != arr[i - 1]) {
                arr[m++] = arr[i];
            }
        }
        BinaryIndexedTree tree = new BinaryIndexedTree(m);
        for (int i = 0; i < n; i++) {
            int j = search(arr, nums[i] - i, m) + 1;
            long v = Math.max(tree.query(j), 0) + nums[i];
            tree.update(j, v);
        }
        return tree.query(m);
    }

    private int search(int[] nums, int x, int r) {
        int l = 0;
        while (l < r) {
            int mid = l + r >> 1;
            if (nums[mid] >= x) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    static class BinaryIndexedTree {
        private static final long INF = 1L << 60;
        private final int         n;
        private final long[]      c;

        BinaryIndexedTree(int _n) {
            n = _n;
            c = new long[_n + 1];
            Arrays.fill(c, -INF);
        }

        void update(int _x, long _v) {
            while (_x <= n) {
                c[_x] = Math.max(c[_x], _v);
                _x += _x & -_x;
            }
        }

        long query(int _x) {
            long mx = -INF;
            while (_x > 0) {
                mx = Math.max(mx, c[_x]);
                _x -= _x & -_x;
            }
            return mx;
        }

    }

}
