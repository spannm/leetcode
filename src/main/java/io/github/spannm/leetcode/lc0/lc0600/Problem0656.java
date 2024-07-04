package io.github.spannm.leetcode.lc0.lc0600;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Problem0656 extends LeetcodeProblem {

    List<Integer> cheapestJump(int[] _arr, int _b) {
        int[] next = new int[_arr.length];
        long[] dp = new long[_arr.length];
        Arrays.fill(next, -1);
        List<Integer> res = new ArrayList<>();
        for (int i = _arr.length - 2; i >= 0; i--) {
            long minCost = Integer.MAX_VALUE;
            for (int j = i + 1; j <= i + _b && j < _arr.length; j++) {
                if (_arr[j] >= 0) {
                    long cost = _arr[i] + dp[j];
                    if (cost < minCost) {
                        minCost = cost;
                        next[i] = j;
                    }
                }
            }
            dp[i] = minCost;
        }
        int i;
        for (i = 0; i < _arr.length && next[i] > 0; i = next[i]) {
            res.add(i + 1);
        }
        if (i == _arr.length - 1 && _arr[i] >= 0) {
            res.add(_arr.length);
        } else {
            return List.of();
        }
        return res;
    }

}
