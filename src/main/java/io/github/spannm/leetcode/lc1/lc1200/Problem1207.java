package io.github.spannm.leetcode.lc1.lc1200;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.*;

class Problem1207 extends LeetcodeProblem {

    boolean uniqueOccurrences(int[] _arr) {
        Map<Integer, Integer> map = new HashMap<>();
        Arrays.stream(_arr).forEach(num -> map.put(num, map.containsKey(num) ? map.get(num) + 1 : 1));
        Set<Integer> set = new HashSet<>();
        return map.keySet().stream().mapToInt(key -> key).allMatch(key -> set.add(map.get(key)));
    }

}
