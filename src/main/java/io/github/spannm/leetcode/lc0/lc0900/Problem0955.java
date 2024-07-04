package io.github.spannm.leetcode.lc0.lc0900;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 955. Delete Columns to Make Sorted II.
 */
class Problem0955 extends LeetcodeProblem {

    int minDeletionSize(String[] _s) {
        if (_s == null || _s.length <= 1) {
            return 0;
        }
        int len = _s.length;
        int wordLen = _s[0].length();
        int res = 0;
        boolean[] cut = new boolean[len];
        search: for (int j = 0; j < wordLen; j++) {

            for (int i = 0; i < len - 1; i++) {
                if (!cut[i] && _s[i].charAt(j) > _s[i + 1].charAt(j)) {
                    res += 1;
                    continue search;
                }
            }

            for (int i = 0; i < len - 1; i++) {
                if (_s[i].charAt(j) < _s[i + 1].charAt(j)) {
                    cut[i] = true;
                }
            }
        }
        return res;
    }

}
