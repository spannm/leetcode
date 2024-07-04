package io.github.spannm.leetcode.lc0.lc0900;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.stream.Collectors;

class Problem0954 extends LeetcodeProblem {

    boolean canReorderDoubled(int[] _arr) {
        Map<Integer, Long> map = Arrays.stream(_arr).boxed().collect(Collectors.groupingBy(i -> i, Collectors.counting()));
        Integer[] sorted = new Integer[_arr.length];
        for (int i = 0; i < _arr.length; i++) {
            sorted[i] = _arr[i];
        }
        Arrays.sort(sorted, Comparator.comparingInt(Math::abs));
        for (int num : sorted) {
            if (map.get(num) == 0) {
                continue;
            }
            if (!map.containsKey(2 * num) || map.get(2 * num) <= 0) {
                return false;
            }
            map.put(num, map.get(num) - 1);
            map.put(2 * num, map.get(2 * num) - 1);
        }
        return true;
    }

}
