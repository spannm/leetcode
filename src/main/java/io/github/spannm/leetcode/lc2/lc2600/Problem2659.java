package io.github.spannm.leetcode.lc2.lc2600;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 2659. Make Array Empty.
 */
class Problem2659 extends LeetcodeProblem {

    long countOperationsToEmptyArray(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> pos = new HashMap<>();
        for (int i = 0; i < n; i++) {
            pos.put(nums[i], i);
        }
        Arrays.sort(nums);
        long ans = pos.get(nums[0]) + 1;
        BinaryIndexedTree tree = new BinaryIndexedTree(n);
        for (int k = 0; k < n - 1; k++) {
            int i = pos.get(nums[k]);
            int j = pos.get(nums[k + 1]);
            long d = j - i - (tree.query(j + 1) - tree.query(i + 1));
            ans += d + (n - k) * (i > j ? 1 : 0);
            tree.update(i + 1, 1);
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
