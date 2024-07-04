package io.github.spannm.leetcode.lc1.lc1000;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.stream.IntStream;

class Problem1078 extends LeetcodeProblem {

    String[] findOcurrences(String _text, String _first, String _second) {
        String[] words = _text.split(" ");
        return IntStream
            .range(0, words.length - 2)
            .filter(i -> words[i].equals(_first) && words[i + 1].equals(_second))
            .mapToObj(i -> words[i + 2])
            .toArray(String[]::new);
    }

}
