package io.github.spannm.leetcode.lc1.lc1700;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem1793 extends LeetcodeProblem {

    int maximumScore(int[] _nums, int _k) {
        int min = _nums[_k];
        int left = _k;
        int right = _k;
        int ans = _nums[_k];
        int len = _nums.length;

        while (left > 0 || right < len - 1) {
            int leftItem = left > 0 ? _nums[left - 1] : 0;
            int rightItem = right < len - 1 ? _nums[right + 1] : 0;

            if (leftItem < rightItem) {
                right++;
                min = Math.min(min, _nums[right]);
            } else {
                left--;
                min = Math.min(min, _nums[left]);
            }

            ans = Math.max(ans, min * (right - left + 1));
        }

        return ans;
    }

}
