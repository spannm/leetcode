package io.github.spannm.leetcode.lc1.lc1100;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.stream.IntStream;

class Problem1137 extends LeetcodeProblem {

    int tribonacci(int _n) {
        if (_n <= 1) {
            return _n;
        }
        int[] numbers = new int[_n + 1];
        numbers[1] = 1;
        numbers[2] = 1;
        IntStream.rangeClosed(3, _n).forEach(i -> numbers[i] = numbers[i - 1] + numbers[i - 2] + numbers[i - 3]);
        return numbers[_n];
    }

}
