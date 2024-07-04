package io.github.spannm.leetcode.lc2.lc2700;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * <a href="https://leetcode.com/problems/extra-characters-in-a-string/">2707. Extra Characters in a String </a>.
 */
class Problem2707 extends LeetcodeProblem {

    int minExtraChar(String _s, String[] _dictionary) {
        int len = _s.length();
        Integer[] memo = new Integer[len];

        Set<String> dictionary = Arrays.stream(_dictionary).collect(Collectors.toSet());

        int res = minExtraChar(dictionary, _s, len, 0, memo);

        _dictionary = null;
        memo = null;
        dictionary = null;
        System.gc();

        return res;
    }

    private static int minExtraChar(final Set<String> _dictionary,
        final String _s,
        int _slen,
        final int _index, final Integer[] _memo) {

        if (_slen == _index) {
            return 0;
        } else if (_memo[_index] != null) {
            return _memo[_index];
        }

        int res = minExtraChar(_dictionary, _s, _slen, _index + 1, _memo) + 1;

        for (int i = _index; i < _slen; i++) {
            String temp = _s.substring(_index, i + 1);

            if (_dictionary.contains(temp)) {
                res = Math.min(res, minExtraChar(_dictionary, _s, _slen, i + 1, _memo));
            }
        }

        return _memo[_index] = res;
    }

}
