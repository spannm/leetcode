package io.github.spannm.leetcode.lc0.lc0000;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem0008 extends LeetcodeProblem {

    int myAtoi(String _s) {
        if (_s == null || _s.isEmpty()) {
            return 0;
        }
        final StringBuilder sb = new StringBuilder(_s);
        while (sb.charAt(0) == ' ') {
            sb.deleteCharAt(0);
            if (sb.isEmpty()) {
                return 0;
            }
        }
        if (!sb.isEmpty()) {
            boolean neg = false;
            char c = sb.charAt(0);
            if (c == '+') {
                sb.deleteCharAt(0);
            } else if (c == '-') {
                sb.deleteCharAt(0);
                neg = true;
            }
            for (int i = 0; i < sb.length(); i++) {
                if (!Character.isDigit(sb.charAt(i))) {
                    sb.delete(i, sb.length());
                    break;
                }
            }
            final String digits = sb.toString();
            if (digits.isEmpty()) {
                return 0;
            }
            java.math.BigDecimal bd = new java.math.BigDecimal(digits);
            if (neg) {
                bd = bd.negate();
            }
            if (bd.compareTo(java.math.BigDecimal.valueOf(Integer.MIN_VALUE)) < 0) {
                return Integer.MIN_VALUE;
            } else if (bd.compareTo(java.math.BigDecimal.valueOf(Integer.MAX_VALUE)) > 0) {
                return Integer.MAX_VALUE;
            }
            return bd.intValue();
        }

        return 0;
    }

}
