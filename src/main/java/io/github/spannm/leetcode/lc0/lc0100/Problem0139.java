package io.github.spannm.leetcode.lc0.lc0100;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/word-break/">139. Word Break</a>.
 */
class Problem0139 extends LeetcodeProblem {

    boolean wordBreak(String _str, List<String> _words) {

        List<String> words = _words.stream().filter(_str::contains).toList();
        Map<String, Boolean> memo = new HashMap<>(); // for memoization
        boolean result = isPossible(_str, words, memo);

        _words = null;
        words = null;
        memo = null;
        System.gc();

        return result;
    }

    static boolean isPossible(final String _target, final List<String> _words, final Map<String, Boolean> _memo) {

        if (_memo.containsKey(_target)) {
            return _memo.get(_target);
        }

        if (_target.isEmpty()) {
            return true;
        }

        for (String word : _words) {
            if (_target.startsWith(word)) {
                if (isPossible(_target.substring(word.length()), _words, _memo)) {

                    _memo.put(_target, true);
                    return true;
                }
            }
        }

        _memo.put(_target, false);
        return false;
    }

}
