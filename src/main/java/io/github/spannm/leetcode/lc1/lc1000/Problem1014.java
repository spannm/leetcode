package io.github.spannm.leetcode.lc1.lc1000;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem1014 extends LeetcodeProblem {

    int maxScoreSightseeingPair(int[] _arr) {
        int bestPrevious = _arr[0];
        int maxSum = 0;

        for (int i = 1; i < _arr.length; i++) {
            maxSum = Math.max(maxSum, bestPrevious + _arr[i] - i);
            bestPrevious = Math.max(bestPrevious, _arr[i] + i);
        }

        return maxSum;
    }

}
