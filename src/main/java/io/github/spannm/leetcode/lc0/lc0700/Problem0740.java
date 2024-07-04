package io.github.spannm.leetcode.lc0.lc0700;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem0740 extends LeetcodeProblem {

    int deleteAndEarn(int[] _nums) {
        int n = 10001;
        int[] values = new int[n];
        for (int num : _nums) {
            values[num] += num;
        }

        int take = 0;
        int skip = 0;
        for (int i = 0; i < n; i++) {
            int takeI = skip + values[i];
            int skipI = Math.max(skip, take);
            take = takeI;
            skip = skipI;
        }
        return Math.max(take, skip);
    }

}
