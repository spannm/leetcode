package io.github.spannm.leetcode.lc0.lc0900;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 926. Flip String to Monotone Increasing.
 */
class Problem0926 extends LeetcodeProblem {

    int minFlipsMonoIncr(String _s) {
        int len = _s.length();
        int[] left = new int[len + 1];
        int[] right = new int[len + 1];
        int ans = Integer.MAX_VALUE;
        for (int i = 1; i <= len; i++) {
            left[i] = left[i - 1] + (_s.charAt(i - 1) == '1' ? 1 : 0);
        }
        for (int i = len - 1; i >= 0; i--) {
            right[i] = right[i + 1] + (_s.charAt(i) == '0' ? 1 : 0);
        }
        for (int i = 0; i <= len; i++) {
            ans = Math.min(ans, left[i] + right[i]);
        }
        return ans;
    }

}
