package io.github.spannm.leetcode.lc1.lc1200;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.*;

class Problem1258 extends LeetcodeProblem {

    List<String> generateSentences(List<List<String>> _synonyms, String _text) {
        String[] words = _text.split(" ");
        Map<String, Set<String>> map = buildSynonymDict(words, _synonyms);
        Set<String> result = new HashSet<>();
        result.add(_text);
        for (int i = 0; i < words.length; i++) {
            List<String> list = new ArrayList<>();
            for (String next : result) {
                list.add(next);
                list.addAll(findAllSynonymForThisWord(next, i, map));
            }
            result.addAll(list);
        }
        List<String> list = new ArrayList<>(result);
        Collections.sort(list);
        return list;
    }

    private List<String> findAllSynonymForThisWord(String _sentence, int _i, Map<String, Set<String>> _map) {
        String[] words = _sentence.split(" ");
        List<String> list = new ArrayList<>();
        Set<String> synonyms = _map.get(words[_i]);
        for (String s : synonyms) {
            words[_i] = s;
            list.add(formWord(words));
        }
        return list;
    }

    private String formWord(String[] _words) {
        StringBuilder sb = new StringBuilder();
        for (String word : _words) {
            sb.append(word);
            sb.append(" ");
        }
        return sb.substring(0, sb.length() - 1);
    }

    private Map<String, Set<String>> buildSynonymDict(String[] _words, List<List<String>> _synonyms) {
        Map<String, Set<String>> map = new HashMap<>();
        for (String key : _words) {
            map.computeIfAbsent(key, k -> new HashSet<>()).add(key);
        }
        for (List<String> list : _synonyms) {
            for (String key : map.keySet()) {
                if (map.get(key).contains(list.get(0))) {
                    map.get(key).add(list.get(1));
                } else if (map.get(key).contains(list.get(1))) {
                    map.get(key).add(list.get(0));
                }
            }
        }
        return map;
    }

}
