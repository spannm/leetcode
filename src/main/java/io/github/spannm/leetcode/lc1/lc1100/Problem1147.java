package io.github.spannm.leetcode.lc1.lc1100;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 1147. Longest Chunked Palindrome Decomposition.
 */
class Problem1147 extends LeetcodeProblem {

    int longestDecomposition(String _text) {
        int ans = 0;
        for (int i = 0, j = _text.length() - 1; i <= j;) {
            boolean ok = false;
            for (int k = 1; i + k - 1 < j - k + 1; k++) {
                if (check(_text, i, j - k + 1, k)) {
                    ans += 2;
                    i += k;
                    j -= k;
                    ok = true;
                    break;
                }
            }
            if (!ok) {
                ans++;
                break;
            }
        }
        return ans;
    }

    private boolean check(String _s, int _i, int _j, int _k) {
        while (_k-- > 0) {
            if (_s.charAt(_i++) != _s.charAt(_j++)) {
                return false;
            }
        }
        return true;
    }

}
