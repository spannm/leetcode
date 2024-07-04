package io.github.spannm.leetcode.lc0.lc0100;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem0171 extends LeetcodeProblem {

    int titleToNumber(String _s) {
        char[] c = _s.toCharArray();
        int len = _s.length();
        int result = 0;
        for (int i = len - 1; i >= 0; i--) {
            result += (c[i] - 64) * (int) Math.pow(26, len - i - 1);
        }
        return result;
    }

}
