package io.github.spannm.leetcode.lc1.lc1700;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.*;

/**
 * 1713. Minimum Operations to Make a Subsequence.
 */
class Problem1713 extends LeetcodeProblem {

    int minOperations(int[] target, int[] arr) {
        Map<Integer, Integer> d = new HashMap<>();
        for (int i = 0; i < target.length; i++) {
            d.put(target[i], i);
        }
        List<Integer> nums = new ArrayList<>();
        for (int element : arr) {
            if (d.containsKey(element)) {
                nums.add(d.get(element));
            }
        }
        return target.length - lengthOfLIS(nums);
    }

    private int lengthOfLIS(List<Integer> nums) {
        Set<Integer> ts = new TreeSet<>(nums);
        int idx = 1;
        Map<Integer, Integer> d = new HashMap<>();
        for (int v : ts) {
            d.put(v, idx++);
        }
        int ans = 0;
        BinaryIndexedTree tree = new BinaryIndexedTree(nums.size());
        for (int v : nums) {
            int x = d.get(v);
            int t = tree.query(x - 1) + 1;
            ans = Math.max(ans, t);
            tree.update(x, t);
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

        static int lowbit(int x) {
            return x & -x;
        }

        void update(int x, int val) {
            while (x <= n) {
                c[x] = Math.max(c[x], val);
                x += lowbit(x);
            }
        }

        int query(int x) {
            int s = 0;
            while (x > 0) {
                s = Math.max(s, c[x]);
                x -= lowbit(x);
            }
            return s;
        }

    }

}
