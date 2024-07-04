package io.github.spannm.leetcode.lc1.lc1700;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem1790 extends LeetcodeProblem {

    boolean areAlmostEqual(String _s1, String _s2) {
        if (_s1.equals(_s2)) {
            return true;
        }
        for (int i = 0; i < _s1.length(); i++) {
            for (int j = 0; j < i; j++) {
                String newS1 = swap(_s1, i, j);
                if (newS1.equals(_s2)) {
                    return true;
                }
            }
        }
        return false;
    }

    private String swap(String _str, int _i, int _j) {
        char c = _str.charAt(_i);
        StringBuilder sb = new StringBuilder(_str);
        sb.replace(_i, _i + 1, _str.charAt(_j) + "");
        sb.replace(_j, _j + 1, "" + c);
        return sb.toString();
    }

}
