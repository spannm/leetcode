package io.github.spannm.leetcode.lc0.lc0600;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.*;
import java.util.stream.Collectors;

class Problem0692 extends LeetcodeProblem {

    List<String> topKFrequent(String[] _words, int _k) {
        Map<String, Long> map = Arrays.stream(_words).collect(Collectors.groupingBy(i -> i, Collectors.counting()));

        Set<Map.Entry<String, Long>> sortedset = new TreeSet<>(
            (e1, e2) -> {
                if (!e1.getValue().equals(e2.getValue())) {
                    return (int) (e2.getValue() - e1.getValue());
                } else {
                    return e1.getKey().compareToIgnoreCase(e2.getKey());
                }
            });
        sortedset.addAll(map.entrySet());

        return sortedset.stream().limit(_k).map(Map.Entry::getKey).toList();
    }

}
