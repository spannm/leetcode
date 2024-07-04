package io.github.spannm.leetcode.lc1.lc1900;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem1966 extends LeetcodeProblem {

    int binarySearchableNumbers(int[] _nums) {
        int ans = 0;
        for (int i = 0; i < _nums.length; i++) {
            int j = i + 1;
            for (; j < _nums.length; j++) {
                if (_nums[j] < _nums[i]) {
                    break;
                }
            }
            if (j == _nums.length) {
                int k = i - 1;
                for (; k >= 0; k--) {
                    if (_nums[i] < _nums[k]) {
                        break;
                    }
                }
                if (k <= 0) {
                    ans++;
                }
            }
        }
        return ans;
    }

}
