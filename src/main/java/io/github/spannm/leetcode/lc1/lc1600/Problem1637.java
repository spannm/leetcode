package io.github.spannm.leetcode.lc1.lc1600;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

class Problem1637 extends LeetcodeProblem {

    int maxWidthOfVerticalArea(int[][] _points) {
        List<Integer> l = Arrays.stream(_points).map(p -> p[0]).distinct().sorted().toList();
        return IntStream.range(0, l.size() - 1).map(i -> l.get(i + 1) - l.get(i)).max().orElse(0);
    }

}
