package io.github.spannm.leetcode.lc0.lc0300;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem0306 extends LeetcodeProblem {

    boolean isAdditiveNumber(String _num) {
        int len = _num.length();
        for (int i = 1; i <= len / 2; i++) {
            for (int j = 1; Math.max(j, i) <= len - i - j; j++) {
                if (isValid(i, j, _num)) {
                    return true;
                }
            }
        }
        return false;
    }

    static boolean isValid(int _i, int _j, String _num) {
        if (_num.charAt(0) == '0' && _i > 1 || _num.charAt(_i) == '0' && _j > 1) {
            return false;
        }
        Long x1 = Long.parseLong(_num.substring(0, _i));
        Long x2 = Long.parseLong(_num.substring(_i, _i + _j));
        String sum = "";
        for (int start = _i + _j; start != _num.length(); start += sum.length()) {
            x2 = x2 + x1;
            x1 = x2 - x1;
            sum = x2.toString();
            if (!_num.startsWith(sum, start)) {
                return false;
            }
        }
        return true;
    }

}
