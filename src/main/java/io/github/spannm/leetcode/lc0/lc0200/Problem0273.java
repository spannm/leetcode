package io.github.spannm.leetcode.lc0.lc0200;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem0273 extends LeetcodeProblem {

    private static final String[] BELOW_10  = new String[] {"Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
    private static final String[] BELOW_20  = new String[] {"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    private static final String[] BELOW_100 = new String[] {"Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    private static final String[] OVER_1000 = new String[] {"Thousand", "Million", "Billion"};

    String numberToWords(int _num) {
        if (_num < 10) {
            return BELOW_10[_num];
        }

        String result = hundredHelper(_num % 1000);
        _num = _num / 1000;
        int i = 0;
        while (i < 3 && _num > 0) {
            if (_num % 1000 > 0) {
                result = hundredHelper(_num % 1000) + OVER_1000[i] + " " + result;
            }
            _num = _num / 1000;
            i++;
        }

        return result.trim();
    }

    static String hundredHelper(int _num) {
        String nstr = "";
        if (_num >= 100) {
            nstr = BELOW_10[_num / 100] + " Hundred ";
        }
        _num = _num % 100;
        if (_num >= 20) {
            if (_num % 10 != 0) {
                nstr = nstr + BELOW_100[_num / 10 - 2] + " " + BELOW_10[_num % 10] + " ";
            } else {
                nstr = nstr + BELOW_100[_num / 10 - 2] + " ";
            }
        } else if (_num >= 10) {
            nstr = nstr + BELOW_20[_num % 10] + " ";
        } else if (_num > 0) {
            nstr = nstr + BELOW_10[_num] + " ";
        }
        return nstr;
    }

}
