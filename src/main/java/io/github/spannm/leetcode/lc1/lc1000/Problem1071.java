package io.github.spannm.leetcode.lc1.lc1000;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem1071 extends LeetcodeProblem {

    String gcdOfStrings(String _str1, String _str2) {
        if (_str1.isEmpty() || _str2.isEmpty()) {
            return "";
        }
        String commomDivisor = _str2;
        while (commomDivisor != null && !commomDivisor.isEmpty()) {
            if (isDivisor(_str1, commomDivisor)) {
                return commomDivisor;
            } else {
                commomDivisor = findNextShorterCommonDivisor(_str2, commomDivisor);
            }
        }
        return "";
    }

    private String findNextShorterCommonDivisor(String _str2, String _commomDivisor) {
        int length = nextPossibleLength(_str2, _commomDivisor.length() - 1);
        while (length > 1) {
            if (isDivisor(_str2, length)) {
                return _str2.substring(0, length);
            }
            length = nextPossibleLength(_str2, length - 1);
        }
        return null;
    }

    private static boolean isDivisor(String _str2, int _length) {
        String commonDivisorCandidate = _str2.substring(0, _length);
        for (int i = 0; i < _str2.length() - _length; i += _length) {
            if (!_str2.substring(i, i + _length).equals(commonDivisorCandidate)) {
                return false;
            }
        }
        return true;
    }

    private static boolean isDivisor(String _str1, String _commomDivisor) {
        if (_str1.length() == _commomDivisor.length()) {
            return _str1.equals(_commomDivisor);
        }
        int i = 0;
        for (; i < _str1.length() - _commomDivisor.length(); i += _commomDivisor.length()) {
            if (!_str1.startsWith(_commomDivisor, i)) {
                return false;
            }
        }
        return i == _str1.length() - _commomDivisor.length();
    }

    private int nextPossibleLength(String _str2, int _bound) {
        if (_bound <= 0) {
            return -1;
        }
        int len = _bound;
        while (_str2.length() % len != 0) {
            len--;
        }
        return len;
    }

}
