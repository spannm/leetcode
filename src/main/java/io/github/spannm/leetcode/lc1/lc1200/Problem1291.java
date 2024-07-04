package io.github.spannm.leetcode.lc1.lc1200;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 1291. Sequential Digits.
 */
class Problem1291 extends LeetcodeProblem {

    List<Integer> sequentialDigits(int _low, int _high) {
        List<Integer> result = new ArrayList<>();
        for (int i = 1; i < 9; i++) {
            int x = i;
            for (int j = i + 1; j < 10; j++) {
                x = x * 10 + j;
                if (x >= _low && x <= _high) {
                    result.add(x);
                }
            }
        }
        Collections.sort(result);
        return result;
    }

}
