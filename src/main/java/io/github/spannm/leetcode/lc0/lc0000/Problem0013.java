package io.github.spannm.leetcode.lc0.lc0000;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * <a href="https://leetcode.com/problems/roman-to-integer/">13. Roman to Integer</a>.
 */
class Problem0013 extends LeetcodeProblem {

    int romanToInt(final String _s) {
        char prev = ' ';
        int val = 0;
        for (int i = _s.length() - 1; i >= 0; i--) {
            char c = _s.charAt(i);
            val += switch (c) {
                case 'I' -> prev == 'V' || prev == 'X' ? -1 : +1;
                case 'V' -> 5;
                case 'X' -> prev == 'L' || prev == 'C' ? -10 : +10;
                case 'L' -> 50;
                case 'C' -> prev == 'D' || prev == 'M' ? -100 : +100;
                case 'D' -> 500;
                case 'M' -> 1000;
                default -> 0;
            };
            prev = c;
        }
        return val;
    }

}
