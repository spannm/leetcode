package io.github.spannm.leetcode.lc0.lc0200;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Problem0244 extends LeetcodeProblem {

    static class WordDistance {

        private final Map<String, List<Integer>> map;

        WordDistance(String[] _words) {
            map = new HashMap<>();
            for (int i = 0; i < _words.length; i++) {
                map.computeIfAbsent(_words[i], k -> new ArrayList<>()).add(i);
            }
        }

        public int shortest(String _word1, String _word2) {
            List<Integer> list1 = map.get(_word1);
            List<Integer> list2 = map.get(_word2);
            int result = Integer.MAX_VALUE;
            for (int i = 0, j = 0; i < list1.size() && j < list2.size();) {
                int index1 = list1.get(i);
                int index2 = list2.get(j);
                if (index1 < index2) {
                    result = Math.min(result, index2 - index1);
                    i++;
                } else {
                    result = Math.min(result, index1 - index2);
                    j++;
                }
            }
            return result;
        }
    }

}
