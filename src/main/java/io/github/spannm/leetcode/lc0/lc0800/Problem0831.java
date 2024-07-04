package io.github.spannm.leetcode.lc0.lc0800;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 831. Masking Personal Information.
 */
class Problem0831 extends LeetcodeProblem {

    String maskPII(String _s) {
        if (Character.isLetter(_s.charAt(0))) {
            _s = _s.toLowerCase();
            int i = _s.indexOf('@');
            return _s.charAt(0) + "*****" + _s.substring(i - 1);
        }
        StringBuilder sb = new StringBuilder();
        for (char c : _s.toCharArray()) {
            if (Character.isDigit(c)) {
                sb.append(c);
            }
        }
        _s = sb.toString();
        int cnt = _s.length() - 10;
        String suf = "***-***-" + _s.substring(_s.length() - 4);
        return cnt == 0 ? suf : "+" + "*".repeat(cnt) + "-" + suf;
    }

}
