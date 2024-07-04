package io.github.spannm.leetcode.lc0.lc0400;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.HashMap;
import java.util.Map;

class Problem0446 extends LeetcodeProblem {

    int numberOfArithmeticSlices(int[] _arr) {
        int res = 0;
        @SuppressWarnings("unchecked")
        Map<Integer, Integer>[] map = new Map[_arr.length];

        for (int i = 0; i < _arr.length; i++) {
            map[i] = new HashMap<>(i);

            for (int j = 0; j < i; j++) {
                long diff = (long) _arr[i] - _arr[j];
                if (diff <= Integer.MIN_VALUE || diff > Integer.MAX_VALUE) {
                    continue;
                }

                int d = (int) diff;
                int c1 = map[i].getOrDefault(d, 0);
                int c2 = map[j].getOrDefault(d, 0);
                res += c2;
                map[i].put(d, c1 + c2 + 1);
            }
        }

        return res;
    }

}
