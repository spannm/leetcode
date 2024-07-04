package io.github.spannm.leetcode.lc1.lc1500;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem1567 extends LeetcodeProblem {

    int getMaxLen(int[] _nums) {
        final int len = _nums.length;
        int max = 0;
        for (int i = 0; i < len; i++) {
            if (len - i <= max) {
                return max;
            } else if (_nums[i] != 0) {
                int negatives = _nums[i] > 0 ? 0 : 1;
                max = Math.max(max, _nums[i] > 0 ? 1 : 0);
                for (int j = i + 1; j < len; j++) {
                    if (_nums[j] < 0) {
                        negatives++;
                    } else if (_nums[j] == 0) {
                        break;
                    }
                    if (negatives % 2 == 0) {
                        max = Math.max(max, j - i + 1);
                    }
                }
            }
        }
        return max;
    }

}
