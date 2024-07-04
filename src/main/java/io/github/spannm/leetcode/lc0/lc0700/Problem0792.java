package io.github.spannm.leetcode.lc0.lc0700;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

class Problem0792 extends LeetcodeProblem {

    int numMatchingSubseq(String _s, String[] _words) {
        List<List<Node>> buckets = new ArrayList<>(26);
        IntStream.range(0, 26).forEach(i -> buckets.add(new ArrayList<>()));
        for (String word : _words) {
            char start = word.charAt(0);
            buckets.get(start - 'a').add(new Node(word, 0));
        }
        int result = 0;
        for (char c : _s.toCharArray()) {
            List<Node> currBucket = buckets.get(c - 'a');
            buckets.set(c - 'a', new ArrayList<>());
            for (Node node : currBucket) {
                node.index++;
                if (node.index == node.word.length()) {
                    result++;
                } else {
                    char start = node.word.charAt(node.index);
                    buckets.get(start - 'a').add(node);
                }
            }
        }
        return result;
    }

    private static class Node {
        private final String word;
        private int          index;

        Node(String _word, int _index) {
            word = _word;
            index = _index;
        }
    }

}
