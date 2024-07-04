package io.github.spannm.leetcode.lc0.lc0000;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * <a href="https://leetcode.com/problems/integer-to-roman/">12. Integer to Roman</a>.
 */
class Problem0012 extends LeetcodeProblem {

    String intToRoman(final int _num) {
        int[] digits = {_num / 1000, _num / 100 % 10, _num / 10 % 10, _num % 10};
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < digits.length; i++) {
            if (digits[i] < 1) {
                continue;
            }
            switch (i) {
                case 0 -> sb.append(
                    switch (digits[0]) {
                        case 1 -> "M";
                        case 2 -> "MM";
                        case 3 -> "MMM";
                        default -> "";
                    });
                case 1 -> sb.append(
                    switch (digits[1]) {
                        case 1 -> "C";
                        case 2 -> "CC";
                        case 3 -> "CCC";
                        case 4 -> "CD";
                        case 5 -> "D";
                        case 6 -> "DC";
                        case 7 -> "DCC";
                        case 8 -> "DCCC";
                        case 9 -> "CM";
                        default -> "";
                    });
                case 2 -> sb.append(
                    switch (digits[2]) {
                        case 1 -> "X";
                        case 2 -> "XX";
                        case 3 -> "XXX";
                        case 4 -> "XL";
                        case 5 -> "L";
                        case 6 -> "LX";
                        case 7 -> "LXX";
                        case 8 -> "LXXX";
                        case 9 -> "XC";
                        default -> "";
                    });
                default -> sb.append(
                    switch (digits[3]) {
                        case 1 -> "I";
                        case 2 -> "II";
                        case 3 -> "III";
                        case 4 -> "IV";
                        case 5 -> "V";
                        case 6 -> "VI";
                        case 7 -> "VII";
                        case 8 -> "VIII";
                        case 9 -> "IX";
                        default -> "";
                    });
            }
        }
        return sb.toString();
    }

}
