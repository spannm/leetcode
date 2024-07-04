package io.github.spannm.leetcode.lc2.lc2100;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Problem2149 extends LeetcodeProblem {

    int[] rearrangeArray(int[] _nums) {
        Map<String, List<Integer>> m = Arrays.stream(_nums).boxed().collect(Collectors.teeing(
            Collectors.filtering(n -> n > 0, Collectors.toList()),
            Collectors.filtering(n -> n <= 0, Collectors.toList()),
            (p, n) -> Map.of("pos", p, "neg", n)));

        int len = _nums.length;
        int[] result = new int[len];
        for (int i = 0, r = 0; i < m.get("pos").size() && r < len; i++, r++) {
            result[r] = m.get("pos").get(i);
            r++;
            result[r] = m.get("neg").get(i);
        }
        return result;
    }

}
