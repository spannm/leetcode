package io.github.spannm.leetcode.lc0.lc0900;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Problem0953 extends LeetcodeProblem {

    boolean isAlienSorted(String[] _words, String _order) {
        if (_words.length == 1) {
            return true;
        }

        Map<Character, Integer> map = IntStream.range(0, _order.length()).boxed().collect(Collectors.toMap(_order::charAt, i -> i));

        for (int i = 0; i < _words.length - 1; i++) {
            String word1 = _words[i];
            String word2 = _words[i + 1];
            if (!sort(word1, word2, map)) {
                return false;
            }
        }
        return true;
    }

    static boolean sort(String _first, String _second, Map<Character, Integer> _map) {
        for (int i = 0; i < Math.min(_first.length(), _second.length()); i++) {
            if (_first.charAt(i) != _second.charAt(i)) {
                return _map.get(_first.charAt(i)) <= _map.get(_second.charAt(i));
            }
        }
        return _first.length() <= _second.length();
    }

}
