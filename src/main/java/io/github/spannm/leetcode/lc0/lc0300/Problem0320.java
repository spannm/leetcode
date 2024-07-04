package io.github.spannm.leetcode.lc0.lc0300;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.ArrayList;
import java.util.List;

class Problem0320 extends LeetcodeProblem {

    List<String> generateAbbreviations(String _word) {
        return backtrack(_word, new ArrayList<>(), 0, "", 0);
    }

    static List<String> backtrack(String _word, List<String> _result, int _position, String _current, int _count) {
        if (_position == _word.length()) {
            if (_count > 0) {
                _current += _count;
            }
            _result.add(_current);
        } else {
            backtrack(_word, _result, _position + 1, _current, _count + 1);
            backtrack(_word, _result, _position + 1,
                _current + (_count > 0 ? _count : "") + _word.charAt(_position), 0);
        }
        return _result;
    }

}
