package io.github.spannm.leetcode.lc0.lc0800;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

class Problem0819 extends LeetcodeProblem {

    String mostCommonWord(String _paragraph, String[] _banned) {
        List<String> words = new ArrayList<>(List.of(_paragraph.toLowerCase().split("[\\!\\?',;\\.\\s]+")));
        words.removeAll(Set.of(_banned));
        Map<String, Long> wordCounts = words.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        Map<Long, String> countWords = wordCounts.entrySet().stream()
            .collect(Collectors.toMap(Map.Entry::getValue, Map.Entry::getKey, (k1, k2) -> k1));
        Long max = Collections.max(countWords.keySet());
        String result = countWords.get(max);

        words = null;
        wordCounts = null;
        countWords = null;

        return result;
    }

}
