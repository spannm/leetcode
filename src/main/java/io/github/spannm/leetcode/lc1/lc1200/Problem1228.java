package io.github.spannm.leetcode.lc1.lc1200;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.*;

class Problem1228 extends LeetcodeProblem {

    int missingNumber(int[] _arr) {
        Arrays.sort(_arr);
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < _arr.length - 1; i++) {
            int diff = _arr[i + 1] - _arr[i];
            List<Integer> list = map.getOrDefault(diff, new ArrayList<>());
            list.add(i);
            map.put(diff, list);
        }
        int smallDiff = _arr[_arr.length - 1];
        int bigDiff = 0;
        for (int key : map.keySet()) {
            smallDiff = Math.min(smallDiff, key);
            bigDiff = Math.max(bigDiff, key);
        }
        return _arr[map.get(bigDiff).get(0)] + smallDiff;
    }

}
