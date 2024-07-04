package io.github.spannm.leetcode.lc0.lc0500;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Arrays;

class Problem0522 extends LeetcodeProblem {

    int findLUSlength(String[] _strs) {
        Arrays.sort(_strs, (o1, o2) -> o2.length() - o1.length());

        for (int i1 = 0; i1 < _strs.length; i1++) {
            boolean found = true;
            for (int i2 = 0; i2 < _strs.length; i2++) {
                if (i1 != i2 && isSubsequence(_strs[i1], _strs[i2])) {
                    found = false;
                    break;
                }
            }
            if (found) {
                return _strs[i1].length();
            }
        }
        return -1;
    }

    static boolean isSubsequence(String _a, String _b) {
        int i = 0;
        for (int j = 0; i < _a.length() && j < _b.length(); j++) {
            if (_a.charAt(i) == _b.charAt(j)) {
                i++;
            }
        }
        return i == _a.length();
    }

}
