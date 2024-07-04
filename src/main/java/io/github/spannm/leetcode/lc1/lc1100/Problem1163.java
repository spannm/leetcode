package io.github.spannm.leetcode.lc1.lc1100;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 1163. Last Substring in Lexicographical Order.
 */
class Problem1163 extends LeetcodeProblem {

    String lastSubstring(String _s) {
        int n = _s.length();
        int i = 0;
        for (int j = 1, k = 0; j + k < n;) {
            int d = _s.charAt(i + k) - _s.charAt(j + k);
            if (d == 0) {
                k++;
            } else if (d < 0) {
                i += k + 1;
                k = 0;
                if (i >= j) {
                    j = i + 1;
                }
            } else {
                j += k + 1;
                k = 0;
            }
        }
        return _s.substring(i);
    }

}
