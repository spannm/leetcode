package io.github.spannm.leetcode.lc0.lc0500;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

class Problem0506 extends LeetcodeProblem {

    String[] findRelativeRanks(int[] _nums) {
        int len = _nums.length;
        int[] sorted = Arrays.stream(_nums).sorted().toArray();
        Map<Integer, String> ranks = new HashMap<>();
        ranks.put(sorted[len - 1], "Gold Medal");
        if (len - 2 > -1) {
            ranks.put(sorted[len - 2], "Silver Medal");
            if (len - 3 > -1) {
                ranks.put(sorted[len - 3], "Bronze Medal");
            }
        }
        IntStream.rangeClosed(0, len - 4).forEach(i -> ranks.put(sorted[i], String.valueOf(len - i)));
        return IntStream.range(0, len).mapToObj(i -> ranks.get(_nums[i])).toArray(String[]::new);
    }

}
