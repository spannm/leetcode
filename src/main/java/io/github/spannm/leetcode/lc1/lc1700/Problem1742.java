package io.github.spannm.leetcode.lc1.lc1700;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.HashMap;
import java.util.Map;

class Problem1742 extends LeetcodeProblem {

    int countBalls(int _lowLimit, int _highLimit) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int limit = _lowLimit; limit <= _highLimit; limit++) {
            int number = 0;
            int tmp = limit;
            do {
                number += tmp % 10;
                tmp /= 10;
            } while (tmp != 0);
            map.put(number, map.getOrDefault(number, 0) + 1);
        }
        int maxBalls = 0;
        for (int c : map.keySet()) {
            maxBalls = Math.max(maxBalls, map.get(c));
        }
        return maxBalls;
    }

}
