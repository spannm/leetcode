package io.github.spannm.leetcode.lc0.lc0300;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 396. Rotate Function.
 */
class Problem0396 extends LeetcodeProblem {

    int maxRotateFunction(int[] _nums) {
        int f = 0;
        int s = 0;
        int n = _nums.length;
        for (int i = 0; i < n; i++) {
            f += i * _nums[i];
            s += _nums[i];
        }
        int ans = f;
        for (int i = 1; i < n; i++) {
            f = f + s - n * _nums[n - i];
            ans = Math.max(ans, f);
        }
        return ans;
    }

}
