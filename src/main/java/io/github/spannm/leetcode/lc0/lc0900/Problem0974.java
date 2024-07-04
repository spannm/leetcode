package io.github.spannm.leetcode.lc0.lc0900;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.HashMap;
import java.util.Map;

class Problem0974 extends LeetcodeProblem {

    int subarraysDivByK(int[] _arr, int _k) {
        int count = 0;
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        for (int element : _arr) {
            sum = (sum + element) % _k;
            if (sum < 0) {
                sum += _k;
            }

            count += map.getOrDefault(sum, 0);
            map.compute(sum, (k, v) -> v == null ? 1 : v + 1);
        }

        return count;
    }

}
