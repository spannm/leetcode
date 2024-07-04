package io.github.spannm.leetcode.lc1.lc1400;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

class Problem1426 extends LeetcodeProblem {

    int countElements(int[] _arr) {
        Set<Integer> set = Arrays.stream(_arr).boxed().collect(Collectors.toSet());
        return (int) Arrays.stream(_arr).filter(n -> set.contains(n + 1)).count();
    }

}
