package io.github.spannm.leetcode.lc0.lc0000;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/letter-combinations-of-a-phone-number/">17. Letter Combinations of a Phone
 * Number</a>.
 */
class Problem0017 extends LeetcodeProblem {

    private static final char[][]       DIGITS_TO_CHARS   = new char[][] {null,                                                                                 // 0
        null,                                                                                                                                                   // 1
        {'a', 'b', 'c'},                                                                                                                                        // 2
        {'d', 'e', 'f'},                                                                                                                                        // 3
        {'g', 'h', 'i'}, {'j', 'k', 'l'}, {'m', 'n', 'o'}, {'p', 'q', 'r', 's'}, {'t', 'u', 'v'}, {'w', 'x', 'y', 'z'}
    };

    List<String> letterCombinations(String _digits) {
        if (_digits == null || _digits.isEmpty()) {
            return List.of();
        }
        return new ArrayList<>(cartesianProduct(_digits, new StringBuilder(), 0, new HashSet<>()));
    }

    static Collection<String> cartesianProduct(String _input, StringBuilder _sb, int _idx, Collection<String> _product) {
        if (_sb.length() == _input.length()) {
            _product.add(_sb.toString());
            return _product;
        }

        int val = _input.charAt(_idx) - '0';
        for (int i = 0; i < DIGITS_TO_CHARS[val].length; i++) {
            _sb.append(DIGITS_TO_CHARS[val][i]);
            cartesianProduct(_input, _sb, _idx + 1, _product);
            _sb.deleteCharAt(_sb.length() - 1);
        }
        return _product;
    }

}
