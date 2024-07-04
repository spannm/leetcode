package io.github.spannm.leetcode.lc0.lc0600;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Problem0642 extends LeetcodeProblem {

    static class AutocompleteSystem {

        private final Map<String, Integer>             map;
        private final List<Map.Entry<String, Integer>> answers;
        private final StringBuilder                    sb;

        AutocompleteSystem(String[] _sentences, int[] _times) {
            map = new HashMap<>();
            answers = new ArrayList<>();
            sb = new StringBuilder();

            for (int i = 0; i < _sentences.length; i++) {
                map.put(_sentences[i], map.getOrDefault(_sentences[i], 0) + _times[i]);
            }
        }

        List<String> input(char _c) {
            List<String> result = new ArrayList<>();
            if (_c == '#') {
                map.put(sb.toString(), map.getOrDefault(sb.toString(), 0) + 1);
                sb.setLength(0);
                answers.clear();
            } else {
                sb.append(_c);
                if (sb.length() == 1) {
                    for (Map.Entry<String, Integer> entry : map.entrySet()) {
                        if (entry.getKey().startsWith(sb.toString())) {
                            answers.add(entry);
                        }
                    }
                    answers.sort((a, b) -> a.getValue() == b.getValue() ? a.getKey().compareTo(b.getKey()) : b.getValue() - a.getValue());
                } else {
                    answers.removeIf(stringIntegerEntry -> !stringIntegerEntry.getKey().startsWith(sb.toString()));
                }
                for (int i = 0; i < 3 && i < answers.size(); i++) {
                    result.add(answers.get(i).getKey());
                }
            }
            return result;
        }
    }

}
