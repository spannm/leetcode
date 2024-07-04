package io.github.spannm.leetcode.lc0.lc0900;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 949. Largest Time for Given Digits.
 */
class Problem0949 extends LeetcodeProblem {

    String largestTimeFromDigits(int[] _arr) {
        int ans = -1;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                for (int k = 0; k < 4; k++) {
                    if (i != j && j != k && i != k) {
                        int h = _arr[i] * 10 + _arr[j];
                        int m = _arr[k] * 10 + _arr[6 - i - j - k];
                        if (h < 24 && m < 60) {
                            ans = Math.max(ans, h * 60 + m);
                        }
                    }
                }
            }
        }
        return ans < 0 ? "" : String.format("%02d:%02d", ans / 60, ans % 60);
    }

}
