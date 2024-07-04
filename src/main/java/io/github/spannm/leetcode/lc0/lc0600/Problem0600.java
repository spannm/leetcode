package io.github.spannm.leetcode.lc0.lc0600;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.stream.IntStream;

class Problem0600 extends LeetcodeProblem {

    int findIntegers(int _num) {
        int[] f = new int[32];
        f[0] = 1;
        f[1] = 2;
        IntStream.range(2, f.length).forEach(i -> f[i] = f[i - 1] + f[i - 2]);
        int i = 30;
        int sum = 0;
        int prevBit = 0;
        while (i >= 0) {
            if (0 != (_num & 1 << i)) {
                sum += f[i];
                if (1 == prevBit) {
                    sum--;
                    break;
                }
                prevBit = 1;
            } else {
                prevBit = 0;
            }
            i--;
        }
        return sum + 1;
    }

}
