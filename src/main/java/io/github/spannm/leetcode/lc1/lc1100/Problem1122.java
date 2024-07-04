package io.github.spannm.leetcode.lc1.lc1100;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

class Problem1122 extends LeetcodeProblem {

    int[] relativeSortArray(int[] _arr1, int[] _arr2) {
        Map<Integer, Long> map = Arrays.stream(_arr1).boxed().collect(Collectors.groupingBy(i -> i, TreeMap::new, Collectors.counting()));
        int[] result = new int[_arr1.length];
        int i = 0;
        for (int num : _arr2) {
            long count = map.get(num);
            while (count-- > 0) {
                result[i++] = num;
            }
            map.remove(num);
        }
        for (Map.Entry<Integer, Long> e : map.entrySet()) {
            long count = e.getValue();
            while (count-- > 0) {
                result[i++] = e.getKey();
            }
        }
        return result;
    }

}
