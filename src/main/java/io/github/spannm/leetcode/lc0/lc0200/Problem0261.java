package io.github.spannm.leetcode.lc0.lc0200;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem0261 extends LeetcodeProblem {

    boolean validTree(int _n, int[][] _edges) {
        int[] nums = new int[_n];
        for (int i = 0; i < _n; i++) {
            nums[i] = i;
        }

        for (int[] edge : _edges) {
            int x = find(nums, edge[0]);
            int y = find(nums, edge[1]);

            if (x == y) {
                return false;
            }

            nums[x] = y;
        }

        return _edges.length == _n - 1;
    }

    int find(int[] _nums, int _i) {
        if (_nums[_i] == _i) {
            return _i;
        }
        return find(_nums, _nums[_i]);
    }

}
