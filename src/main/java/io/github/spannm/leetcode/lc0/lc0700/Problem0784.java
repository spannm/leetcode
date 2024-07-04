package io.github.spannm.leetcode.lc0.lc0700;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/letter-case-permutation/">784. Letter Case Permutation</a>.
 */
class Problem0784 extends LeetcodeProblem {

    List<String> letterCasePermutation(String _str) {
        return permuteCase(_str.toCharArray(), 0, new ArrayList<>());
    }

    static List<String> permuteCase(char[] _chars, int _index, List<String> _results) {
        if (_index == _chars.length) {
            // done
            _results.add(new String(_chars));
        } else if (Character.isDigit(_chars[_index])) {
            // skip digit
            permuteCase(_chars, _index + 1, _results);
        } else {
            _chars[_index] = Character.toLowerCase(_chars[_index]);
            permuteCase(_chars, _index + 1, _results);

            _chars[_index] = Character.toUpperCase(_chars[_index]);
            permuteCase(_chars, _index + 1, _results);
        }

        return _results;
    }

}
