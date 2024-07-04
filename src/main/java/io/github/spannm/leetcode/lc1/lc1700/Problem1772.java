package io.github.spannm.leetcode.lc1.lc1700;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.*;

class Problem1772 extends LeetcodeProblem {

    String[] sortFeatures(String[] _features, String[] _responses) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < _features.length; i++) {
            map.put(_features[i], i);
        }
        Map<String, Integer> countMap = new HashMap<>();
        for (String response : _responses) {
            Set<String> strs = new HashSet<>(List.of(response.split(" ")));
            for (String str : strs) {
                if (map.containsKey(str)) {
                    countMap.put(str, countMap.getOrDefault(str, 0) + 1);
                }
            }
        }
        Queue<Node> maxHeap = new PriorityQueue<>((a, b) -> !a.freq.equals(b.freq) ? b.freq - a.freq : a.index - b.index);
        for (String key : map.keySet()) {
            maxHeap.offer(new Node(key, countMap.getOrDefault(key, 0), map.get(key)));
        }
        String[] result = new String[_features.length];
        int i = 0;
        while (!maxHeap.isEmpty()) {
            result[i++] = maxHeap.poll().word;
        }
        return result;
    }

    static class Node {
        private final String  word;
        private final Integer freq;
        private final Integer index;

        Node(String _word, Integer _freq, Integer _index) {
            word = _word;
            freq = _freq;
            index = _index;
        }
    }

}
