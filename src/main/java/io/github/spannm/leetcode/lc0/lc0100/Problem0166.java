package io.github.spannm.leetcode.lc0.lc0100;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/fraction-to-recurring-decimal/">166. Fraction to Recurring Decimal</a>.
 */
class Problem0166 extends LeetcodeProblem {

    String fractionToDecimal(int _numerator, int _denominator) {
        if (_numerator == 0) {
            return "0";
        }
        String sign = _numerator >= 0 && _denominator >= 0 || _numerator < 0 && _denominator < 0 ? "" : "-";
        long num = Math.abs((long) _numerator);
        long deno = Math.abs((long) _denominator);
        long integral = Math.abs(num / deno);
        StringBuilder sb = new StringBuilder()
            .append(sign)
            .append(integral);
        if (_numerator % _denominator == 0) {
            return sb.toString();
        }

        sb.append(".");
        long remainder = num % deno;

        Map<Long, Integer> map = new HashMap<>();
        while (!map.containsKey(remainder)) {
            map.put(remainder, sb.length());
            long n = remainder * 10 / deno;
            remainder = remainder * 10 % deno;
            if (remainder != 0 || !map.containsKey(remainder)) {
                sb.append(n);
            }
        }
        if (remainder != 0) {
            sb.insert(map.get(remainder), "(")
                .append(")");
        }
        return sb.toString();
    }

}
