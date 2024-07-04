package io.github.spannm.leetcode.lc0.lc0100;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem0161 extends LeetcodeProblem {

    boolean isOneEditDistance(String _s, String _t) {
        char[] schar = _s.toCharArray();
        char[] tchar = _t.toCharArray();

        if (Math.abs(_s.length() - _t.length()) == 1) {
            char[] longer = _s.length() > _t.length() ? schar : tchar;
            char[] shorter = longer == schar ? tchar : schar;

            int diffCnt = 0;
            int i = 0;
            int j = 0;
            while (i < shorter.length && j < longer.length) {
                if (longer[j] != shorter[i]) {
                    diffCnt++;
                } else {
                    i++;
                }
                j++;
            }
            return diffCnt == 1 || diffCnt == 0;

        } else if (_s.length() == _t.length()) {
            int diffCnt = 0;
            for (int i = 0; i < _s.length(); i++) {
                if (schar[i] != tchar[i]) {
                    diffCnt++;
                }
                if (diffCnt > 1) {
                    return false;
                }
            }
            return diffCnt == 1;
        }
        return false;
    }

}
