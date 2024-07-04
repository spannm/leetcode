package io.github.spannm.leetcode.lc0.lc0000;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * <a href="https://leetcode.com/problems/multiply-strings/">43. Multiply Strings</a>.
 */
class Problem0043 extends LeetcodeProblem {

    String multiply(final String _num1, final String _num2) {
        if (_num1.chars().allMatch(c -> c == '0') || _num2.chars().allMatch(c1 -> c1 == '0')) {
            return "0";
        }
        int[] a1 = new int[_num1.length()];
        int[] a2 = new int[_num2.length()];
        int[] product = new int[_num1.length() + _num2.length()];

        for (int i = a1.length - 1; i >= 0; i--) {
            for (int j = a2.length - 1; j >= 0; j--) {
                int thisProduct = Character.getNumericValue(_num1.charAt(i)) * Character.getNumericValue(_num2.charAt(j));
                product[i + j + 1] += thisProduct % 10;
                if (product[i + j + 1] >= 10) {
                    product[i + j + 1] %= 10;
                    product[i + j]++;
                }
                product[i + j] += thisProduct / 10;
                if (product[i + j] >= 10) {
                    product[i + j] %= 10;
                    product[i + j - 1]++;
                }
            }
        }

        return IntStream.range(0, product.length).filter(i -> i != 0 || product[i] != 0).mapToObj(i -> Integer.toString(product[i])).collect(Collectors.joining(""));
    }

}
