package io.github.spannm.leetcode.lc0.lc0500;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.ArrayList;
import java.util.List;

class Problem0592 extends LeetcodeProblem {

    String fractionAddition(String _expr) {
        List<String> nums = new ArrayList<>();
        int i = 0;
        int j = 0;
        while (j <= _expr.length()) {
            if (j == _expr.length() || j != i && (_expr.charAt(j) == '-' || _expr.charAt(j) == '+')) {
                if (_expr.charAt(i) == '+') {
                    nums.add(_expr.substring(i + 1, j));
                } else {
                    nums.add(_expr.substring(i, j));
                }
                i = j;
            }
            j++;
        }

        String result = "0/1";
        for (String frac : nums) {
            result = add(result, frac);
        }
        return result;
    }

    static String add(String _result, String _frac) {
        String[] frac1 = _frac.split("/");
        String[] frac2 = _result.split("/");
        int n1 = Integer.parseInt(frac1[0]);
        int d1 = Integer.parseInt(frac1[1]);
        int n2 = Integer.parseInt(frac2[0]);
        int d2 = Integer.parseInt(frac2[1]);
        int numerator = n1 * d2 + n2 * d1;
        int denominator = d1 * d2;
        if (numerator == 0) {
            return "0/1";
        }

        boolean negative = numerator * denominator < 0;
        numerator = Math.abs(numerator);
        denominator = Math.abs(denominator);
        int gcd = getGCD(numerator, denominator);

        return (negative ? "-" : "") + numerator / gcd + "/" + denominator / gcd;
    }

    static int getGCD(int _a, int _b) {
        if (_a == 0 || _b == 0) {
            return _a + _b;
        }
        return getGCD(_b, _a % _b);
    }

}
