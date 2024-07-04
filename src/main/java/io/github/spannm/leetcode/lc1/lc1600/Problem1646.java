package io.github.spannm.leetcode.lc1.lc1600;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem1646 extends LeetcodeProblem {

    int getMaximumGenerated(int _n) {
        if (_n == 0) {
            return 0;
        }
        int[] nums = new int[_n + 1];
        nums[0] = 0;
        nums[1] = 1;
        int max = 1;
        for (int i = 1; i <= _n / 2; i++) {
            nums[i * 2] = nums[i];
            max = Math.max(max, nums[i]);
            if (i * 2 + 1 <= _n) {
                nums[i * 2 + 1] = nums[i] + nums[i + 1];
                max = Math.max(max, nums[i * 2 + 1]);
            }
        }
        return max;
    }

}
