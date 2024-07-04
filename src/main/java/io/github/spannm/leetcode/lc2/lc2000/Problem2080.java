package io.github.spannm.leetcode.lc2.lc2000;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.*;

class Problem2080 extends LeetcodeProblem {

    static class RangeFreqQuery {

        private final Map<Integer, List<Integer>> map;

        RangeFreqQuery(int[] _arr) {
            map = new HashMap<>();
            for (int i = 0; i < _arr.length; i++) {
                List<Integer> list = map.getOrDefault(_arr[i], new ArrayList<>());
                list.add(i);
                map.put(_arr[i], list);
            }
        }

        int query(int _left, int _right, int _value) {
            List<Integer> list = map.getOrDefault(_value, new ArrayList<>());
            int start = Collections.binarySearch(list, _left);
            int end = Collections.binarySearch(list, _right);
            if (start < 0) {
                start = (start + 1) * -1;
            }
            if (end < 0) {
                end = (end + 2) * -1;
            }
            return end - start + 1;
        }
    }

}
