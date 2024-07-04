package io.github.spannm.leetcode.lc2.lc2300;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem2380 extends LeetcodeProblem {

    int secondsToRemoveOccurrences(String _s) {
        int seconds = 0;
        StringBuilder sb = new StringBuilder(_s);
        while (hasZeroOneCount(sb)) {
            for (int i = 0; i < sb.length() - 1;) {
                if (sb.charAt(i) == '0' && sb.charAt(i + 1) == '1') {
                    sb.setCharAt(i++, '1');
                    sb.setCharAt(i++, '0');
                } else {
                    i++;
                }
            }
            seconds++;
        }
        return seconds;
    }

    private static boolean hasZeroOneCount(StringBuilder _sb) {
        for (int i = 0; i < _sb.length() - 1; i++) {
            if (_sb.charAt(i) == '0' && _sb.charAt(i + 1) == '1') {
                return true;
            }
        }
        return false;
    }

}
