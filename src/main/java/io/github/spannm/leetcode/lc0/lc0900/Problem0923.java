package io.github.spannm.leetcode.lc0.lc0900;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.HashMap;
import java.util.Map;

class Problem0923 extends LeetcodeProblem {

    int threeSumMulti(int[] _a, int _target) {
        final int mod = 1000000007;
        Map<Integer, Long> map = new HashMap<>();
        for (int num : _a) {
            map.put(num, map.getOrDefault(num, 0L) + 1);
        }
        long result = 0;
        for (int num1 : map.keySet()) {
            for (int num2 : map.keySet()) {
                int num3 = _target - num1 - num2;
                if (map.containsKey(num3)) {
                    Long count1 = map.get(num1);
                    Long count2 = map.get(num2);
                    Long count3 = map.get(num3);
                    if (num1 == num2 && num1 == num3) {
                        result = (result + count1 * (count1 - 1) * (count1 - 2) / 6) % mod;
                    } else if (num1 == num2 && num1 != num3) {
                        result = (result + count1 * (count1 - 1) / 2 * count3) % mod;
                    } else if (num1 < num2 && num2 < num3) {
                        result = (result + count1 * count2 * count3) % mod;
                    }
                }
            }
        }
        return (int) result;
    }

}
