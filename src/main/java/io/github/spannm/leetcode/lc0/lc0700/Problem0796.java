package io.github.spannm.leetcode.lc0.lc0700;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem0796 extends LeetcodeProblem {

    boolean rotateString(String _a, String _b) {
        if (_a.length() != _b.length()) {
            return false;
        }
        for (int i = 0; i < _a.length(); i++) {
            if ((_a.substring(i) + _a.substring(0, i)).equals(_b)) {
                return true;
            }
        }
        return false;
    }

}
