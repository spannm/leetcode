package io.github.spannm.leetcode.lc0.lc0500;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem0564 extends LeetcodeProblem {

    String nearestPalindromic(String _n) {
        if (_n.length() >= 2 && allNine(_n)) {
            return "1" + "0".repeat(_n.length() - 1) + "1";
        }
        boolean isOdd = _n.length() % 2 != 0;
        String left = _n.substring(0, (_n.length() + 1) / 2);
        long[] increment = {-1, 0, +1};
        String ret = _n;
        long minDiff = Long.MAX_VALUE;
        for (long i : increment) {
            String s = getPalindrom(Long.toString(Long.parseLong(left) + i), isOdd);
            if (_n.length() >= 2 && (s.length() != _n.length() || Long.parseLong(s) == 0)) {
                s = "9".repeat(_n.length() - 1);
            }
            long diff = s.equals(_n) ? Long.MAX_VALUE : Math.abs(Long.parseLong(s) - Long.parseLong(_n));
            if (diff < minDiff) {
                minDiff = diff;
                ret = s;
            }
        }
        return ret;
    }

    static String getPalindrom(String _s, boolean _isOdd) {
        String right = new StringBuilder(_s).reverse().toString();
        return _isOdd ? _s.substring(0, _s.length() - 1) + right : _s + right;
    }

    static boolean allNine(String _s) {
        for (int i = 0; i < _s.length(); i++) {
            if (_s.charAt(i) != '9') {
                return false;
            }
        }
        return true;
    }

}
