package io.github.spannm.leetcode.lc0.lc0700;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.HashMap;
import java.util.Map;

class Problem0737 extends LeetcodeProblem {

    boolean areSentencesSimilarTwo(String[] _words1, String[] _words2, String[][] _pairs) {
        if (_words1.length != _words2.length) {
            return false;
        }

        Map<String, String> map = new HashMap<>();
        for (String[] pair : _pairs) {
            if (!map.containsKey(pair[0])) {
                map.put(pair[0], pair[0]);
            }
            if (!map.containsKey(pair[1])) {
                map.put(pair[1], pair[1]);
            }

            setParent(map, pair[0], pair[1]);
        }

        for (int i = 0; i < _words1.length; i++) {
            String parent1 = getParent(map, _words1[i]);
            String parent2 = getParent(map, _words2[i]);
            if (!parent1.equals(parent2)) {
                return false;
            }
        }
        return true;
    }

    private void setParent(Map<String, String> _map, String _word1, String _word2) {
        String parent1 = getParent(_map, _word1);
        String parent2 = getParent(_map, _word2);
        _map.put(parent1, parent2);
    }

    private String getParent(Map<String, String> _map, String _word) {
        if (!_map.containsKey(_word)) {
            return _word;
        }
        while (!_word.equals(_map.get(_word))) {
            _word = _map.get(_word);
        }
        return _word;
    }

}
