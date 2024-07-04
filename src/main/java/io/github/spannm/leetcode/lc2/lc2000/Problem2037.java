package io.github.spannm.leetcode.lc2.lc2000;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Arrays;
import java.util.stream.IntStream;

class Problem2037 extends LeetcodeProblem {

    int minMovesToSeat(int[] _seats, int[] _students) {
        Arrays.sort(_seats);
        Arrays.sort(_students);
        return IntStream.range(0, _seats.length).map(i -> Math.abs(_seats[i] - _students[i])).sum();
    }

}
