package io.github.spannm.leetcode.lc0.lc0800;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Problem0823 extends LeetcodeProblem {

    int numFactoredBinaryTrees(int[] _arr) {
        Arrays.sort(_arr);
        Map<Integer, Long> map = new HashMap<>();
        long count = 1;
        map.put(_arr[0], count);
        for (int i = 1; i < _arr.length; i++) {
            count = 1;
            for (int key : map.keySet()) {
                Long val = map.get(_arr[i] / key);
                if (_arr[i] % key == 0 && val != null) {
                    count += map.get(key) * val;
                }
            }
            map.put(_arr[i], count);
        }
        long sum = 0;
        for (Long val : map.values()) {
            sum = (sum + val) % 1000000007L;
        }
        return (int) sum;
    }

}
