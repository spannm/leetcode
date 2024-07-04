package io.github.spannm.leetcode.lc0.lc0200;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * <a href="https://leetcode.com/problems/basic-calculator/">224. Basic Calculator</a>.
 */
class Problem0224 extends LeetcodeProblem {

    int calculate(final String _s) {
        return calc(_s, _s.length(), new int[] {0});
    }

    static int calc(final String _s, int _len, int[] _idx) {
        int res = 0;
        int num = 0;
        int sign = 1;

        while (_idx[0] < _len) {
            final char c = _s.charAt(_idx[0]++);
            if (c == ' ') {
                continue;
            } else if (c >= '0' && c <= '9') {
                num = num * 10 + c - '0';
            } else if (c == '(') {
                num = calc(_s, _len, _idx); // ( is start of a new sub-problem, Let recursion solve the sub-problem
            } else if (c == ')') {
                return res + sign * num;
            } else if (c == '+' || c == '-') { // only when we meet a new sign, we know a while number has been read
                res += sign * num;
                num = 0;
                sign = c == '-' ? -1 : 1;
            }
        }
        return res + sign * num; // last number is not processed yet
    }

}
