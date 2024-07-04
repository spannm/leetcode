package io.github.spannm.leetcode.lc0.lc0100;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.*;

/**
 * <a href="https://leetcode.com/problems/word-ladder-ii/">126. Word Ladder II</a>.
 */
class Problem0126 extends LeetcodeProblem {

    List<List<String>> findLadders(String _start, String _end, List<String> _dict) {
        if (_dict.isEmpty()) {
            return List.of();
        }

        Map<String, List<String>> map = new HashMap<>();
        int min = Integer.MAX_VALUE;

        Queue<String> queue = new ArrayDeque<>();
        queue.add(_start);

        Map<String, Integer> ladder = new HashMap<>();
        for (String string : _dict) {
            ladder.put(string, Integer.MAX_VALUE);
        }
        ladder.put(_start, 0);

        while (!queue.isEmpty()) {

            String word = queue.poll();

            int step = ladder.get(word)
                + 1;

            if (step > min) {
                break;
            }

            for (int i = 0; i < word.length(); i++) {
                StringBuilder sb = new StringBuilder(word);
                for (char ch = 'a'; ch <= 'z'; ch++) {
                    sb.setCharAt(i, ch);
                    String newWord = sb.toString();
                    if (ladder.containsKey(newWord)) {

                        if (step > ladder.get(newWord)) {

                            continue;
                        } else if (step < ladder.get(newWord)) {
                            queue.add(newWord);
                            ladder.put(newWord, step);
                        }
                        map.computeIfAbsent(newWord, k -> new LinkedList<>());
                        map.get(newWord).add(word);

                        if (newWord.equals(_end)) {
                            min = step;
                        }
                    }

                }

            }

        }

        return backTrace(_end, _start, new LinkedList<>(), map, new ArrayList<>());
    }

    static List<List<String>> backTrace(String _word, String _start, List<String> _list,
        Map<String, List<String>> _map, List<List<String>> _results) {
        if (_word.equals(_start)) {
            _list.add(0, _start);
            _results.add(new ArrayList<>(_list));
        } else {
            _list.add(0, _word);
            if (_map.get(_word) != null) {
                for (String s : _map.get(_word)) {
                    backTrace(s, _start, _list, _map, _results);
                }
            }
        }
        _list.remove(0);
        return _results;
    }

}
