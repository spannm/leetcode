package io.github.spannm.leetcode.lc0.lc0500;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Problem0594 extends LeetcodeProblem {

    int findLHS(int[] _nums) {
        Map<Integer, Integer> map = new HashMap<>();
        Arrays.stream(_nums).forEach(n -> map.merge(n, 1, Integer::sum));
        return Arrays.stream(_nums).filter(n -> map.get(n + 1) != null).map(n -> map.get(n) + map.get(n + 1)).max().orElse(0);
    }

}
