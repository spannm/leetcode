package io.github.spannm.leetcode.lc0.lc0400;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Problem0451 extends LeetcodeProblem {

    String frequencySort(String _s) {
        Map<Character, Integer> map = _s.chars().mapToObj(c -> (char) c).collect(Collectors.toMap(c -> c, v -> 1, Integer::sum, HashMap::new));
        List<Map.Entry<Character, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort((o1, o2) -> (o2.getValue() - o1.getValue()));
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Character, Integer> entry : list) {
            sb.append(String.valueOf(entry.getKey()).repeat(Math.max(0, entry.getValue())));
        }
        return sb.toString();
    }

}
