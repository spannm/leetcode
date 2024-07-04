package io.github.spannm.leetcode.lc2.lc2100;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Arrays;

class Problem2144 extends LeetcodeProblem {

    int minimumCost(int[] _cost) {
        Arrays.sort(_cost);
        int ans = 0;
        for (int i = _cost.length - 1; i >= 0; i--) {
            ans += _cost[i];
            i--;
            if (i >= 0) {
                ans += _cost[i];
            }
            i--;
        }
        return ans;
    }

}
