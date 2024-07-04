package io.github.spannm.leetcode.lc2.lc2200;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Objects;

class Problem2264 extends LeetcodeProblem {

    String largestGoodInteger(String _num) {
        String max = null;
        for (int i = 0; i < _num.length() - 2; i++) {
            if (_num.charAt(i) == _num.charAt(i + 1) && _num.charAt(i + 1) == _num.charAt(i + 2)) {
                String scandidate = _num.substring(i, i + 3);
                if (max == null || max.compareTo(scandidate) < 0) {
                    max = scandidate;
                }
                i += 2;
            }
        }
        return Objects.requireNonNullElse(max, "");
    }

}
