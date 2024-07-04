package io.github.spannm.leetcode.lc0.lc0000;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/generate-parentheses/">22. Generate Parentheses</a>.
 */
class Problem0022 extends LeetcodeProblem {

    List<String> generateParenthesis(int _n) {
        return _n == 0 ? List.of() : backtrack(new ArrayList<>(), "", _n, _n);
    }

    static List<String> backtrack(List<String> _result, String _parens, int _left, int _right) {
        if (_left > 0) {
            backtrack(_result, _parens + '(', _left - 1, _right);
        }
        if (_right > _left) {
            backtrack(_result, _parens + ')', _left, _right - 1);
        }
        if (_right == 0) {
            _result.add(_parens);
        }
        return _result;
    }

}
