package io.github.spannm.leetcode.lc2.lc2700;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Arrays;

/**
 * 2736. Maximum Sum Queries.
 */
class Problem2736 extends LeetcodeProblem {

    int[] maximumSumQueries(int[] nums1, int[] nums2, int[][] queries) {
        int n = nums1.length;
        int[][] nums = new int[n][0];
        for (int i = 0; i < n; i++) {
            nums[i] = new int[] {nums1[i], nums2[i]};
        }
        Arrays.sort(nums, (a, b) -> b[0] - a[0]);
        Arrays.sort(nums2);
        int m = queries.length;
        Integer[] idx = new Integer[m];
        for (int i = 0; i < m; i++) {
            idx[i] = i;
        }
        Arrays.sort(idx, (i, j) -> queries[j][0] - queries[i][0]);
        int[] ans = new int[m];
        int j = 0;
        BinaryIndexedTree tree = new BinaryIndexedTree(n);
        for (int i : idx) {
            int x = queries[i][0];
            int y = queries[i][1];
            for (; j < n && nums[j][0] >= x; j++) {
                int k = n - Arrays.binarySearch(nums2, nums[j][1]);
                tree.update(k, nums[j][0] + nums[j][1]);
            }
            int p = Arrays.binarySearch(nums2, y);
            int k = p >= 0 ? n - p : n + p + 1;
            ans[i] = tree.query(k);
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
