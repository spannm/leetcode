package io.github.spannm.leetcode.lc0.lc0500;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem0551 extends LeetcodeProblem {

    boolean checkRecord(String _s) {
        int aCnt = 0;
        for (int i = 0; i < _s.length(); i++) {
            char c = _s.charAt(i);
            if ('A' == c) {
                aCnt++;
                if (aCnt > 1) {
                    return false;
                }
            } else if ('L' == c) {
                int contLCnt = 0;
                while (i < _s.length() && _s.charAt(i) == 'L') {
                    i++;
                    contLCnt++;
                    if (contLCnt > 2) {
                        return false;
                    }
                }
                i--;
            }
        }
        return true;
    }

}
