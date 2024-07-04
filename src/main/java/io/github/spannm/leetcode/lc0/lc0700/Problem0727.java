package io.github.spannm.leetcode.lc0.lc0700;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem0727 extends LeetcodeProblem {

    String minWindow(String _s, String _t) {
        String result = _s;
        for (int i = 0; i < _s.length(); i++) {
            for (int j = i + _t.length(); j <= _s.length(); j++) {
                String sub = _s.substring(i, j);
                if (sub.length() < result.length() && isSubsequence(_t, sub)) {
                    result = sub;
                }
            }
        }
        return result.equals(_s) ? "" : result;
    }

    private static boolean isSubsequence(String _s, String _sub) {
        int i = 0;
        for (int j = 0; i < _s.length() && j < _sub.length(); j++) {
            if (_s.charAt(i) == _sub.charAt(j)) {
                i++;
            }
        }
        return i == _s.length();
    }

}
