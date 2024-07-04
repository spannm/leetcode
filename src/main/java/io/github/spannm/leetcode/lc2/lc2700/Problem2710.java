package io.github.spannm.leetcode.lc2.lc2700;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem2710 extends LeetcodeProblem {

    String removeTrailingZeros(String _num) {
        StringBuilder sb = new StringBuilder();
        boolean trailing = true;
        for (int i = _num.length() - 1; i >= 0; i--) {
            if (_num.charAt(i) != '0' || !trailing) {
                sb.append(_num.charAt(i));
                trailing = false;
            }
        }
        return sb.reverse().toString();
    }

}
