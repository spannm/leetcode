package io.github.spannm.leetcode.lc1.lc1000;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.ArrayList;
import java.util.List;

class Problem1065 extends LeetcodeProblem {

    int[][] indexPairs(String _text, String[] _words) {
        List<List<Integer>> lists = new ArrayList<>();
        for (String word : _words) {
            lists.addAll(findAllMatchsForThisWord(word, _text));
        }
        if (lists.isEmpty()) {
            return new int[][] {};
        }
        lists.sort((o1, o2) -> {
            if (o1.get(0) > o2.get(0)) {
                return 1;
            } else if (o1.get(0) < o2.get(0)) {
                return -1;
            } else {
                return o1.get(1).compareTo(o2.get(1));
            }
        });
        int[][] result = new int[lists.size()][lists.get(0).size()];
        for (int i = 0; i < lists.size(); i++) {
            result[i][0] = lists.get(i).get(0);
            result[i][1] = lists.get(i).get(1);
        }
        return result;
    }

    static List<List<Integer>> findAllMatchsForThisWord(String _word, String _text) {
        List<List<Integer>> lists = new ArrayList<>();
        for (int i = 0; i <= _text.length() - _word.length(); i++) {
            if (_text.startsWith(_word, i)) {
                lists.add(List.of(i, i + _word.length() - 1));
            }
        }
        return lists;
    }

}
