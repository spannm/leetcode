package io.github.spannm.leetcode.lc1.lc1900;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem1933 extends LeetcodeProblem {

    boolean isDecomposable(String _s) {
        int lengthTwoCount = 0;
        for (int i = 0; i < _s.length(); i++) {
            int start = i;
            char prev = _s.charAt(start);
            while (i < _s.length() && _s.charAt(i) == prev) {
                i++;
            }
            if (i >= _s.length()) {
                i--;
            }
            if (_s.charAt(i) != prev) {
                i--;
            }
            if ((i - start + 1) % 3 == 2) {
                lengthTwoCount++;
            } else if ((i - start + 1) % 3 != 0) {
                return false;
            }
        }
        return lengthTwoCount == 1;
    }

}
