package io.github.spannm.leetcode.lc0.lc0700;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem0769 extends LeetcodeProblem {

    int maxChunksToSorted(int[] _arr) {
        int len = _arr.length;

        int[] maxOfLeft = new int[len];
        maxOfLeft[0] = _arr[0];
        for (int i = 1; i < len; i++) {
            maxOfLeft[i] = Math.max(_arr[i], maxOfLeft[i - 1]);
        }

        int[] minOfRight = new int[len];
        minOfRight[len - 1] = _arr[len - 1];
        for (int i = len - 2; i >= 0; i--) {
            minOfRight[i] = Math.min(minOfRight[i + 1], _arr[i]);
        }

        int result = 0;
        for (int i = 0; i < len - 1; i++) {
            if (maxOfLeft[i] <= minOfRight[i + 1]) {
                result++;
            }
        }
        return result + 1;
    }

}
