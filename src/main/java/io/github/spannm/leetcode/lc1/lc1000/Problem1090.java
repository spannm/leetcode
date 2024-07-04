package io.github.spannm.leetcode.lc1.lc1000;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Problem1090 extends LeetcodeProblem {

    int largestValsFromLabels(int[] _values, int[] _labels, int _numWanted, int _useLimit) {
        int[][] tuple = new int[_values.length][2];
        for (int i = 0; i < _values.length; i++) {
            tuple[i][0] = _values[i];
            tuple[i][1] = _labels[i];
        }
        Arrays.sort(tuple, (a, b) -> b[0] - a[0]);
        Map<Integer, Integer> labelUsedCountMap = new HashMap<>();
        int sum = 0;
        int numbersUsed = 0;
        for (int i = 0; i < _values.length; i++) {
            int val = tuple[i][0];
            int usedCount = labelUsedCountMap.getOrDefault(tuple[i][1], 0);
            if (usedCount >= _useLimit) {
                continue;
            } else {
                sum += val;
                numbersUsed++;
                labelUsedCountMap.put(tuple[i][1], usedCount + 1);
            }
            if (numbersUsed >= _numWanted) {
                break;
            }
        }
        return sum;
    }

}
