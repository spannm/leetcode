package io.github.spannm.leetcode.lc0.lc0900;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.HashMap;
import java.util.Map;

class Problem0914 extends LeetcodeProblem {

    boolean hasGroupsSizeX(int[] _deck) {

        if (_deck.length < 2) {
            return false;
        }

        Map<Integer, Integer> mapReps = new HashMap<>();
        for (int card : _deck) {
            if (!mapReps.containsKey(card)) {
                mapReps.put(card, 1);
            } else {
                mapReps.put(card, mapReps.get(card) + 1);
            }
        }

        int num = 0;
        int[] arrReps = new int[mapReps.size()];
        for (Map.Entry<Integer, Integer> e : mapReps.entrySet()) {
            arrReps[num++] = e.getValue();
        }

        num = arrGCD(arrReps, arrReps.length);

        return num > 1;
    }

    private static int gcd(int _a, int _b) {
        return _b == 0 ? _a : gcd(_b, _a % _b);
    }

    private static int arrGCD(int[] _arr, int _n) {
        int result = _arr[0];
        for (int i = 1; i < _n; i++) {
            result = gcd(_arr[i], result);
        }

        return result;
    }

}
