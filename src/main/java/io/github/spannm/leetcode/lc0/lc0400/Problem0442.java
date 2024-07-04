package io.github.spannm.leetcode.lc0.lc0400;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Problem0442 extends LeetcodeProblem {

    List<Integer> findDuplicates(int[] _nums) {
        Set<Integer> set = new HashSet<>();
        return Arrays.stream(_nums).filter(n -> !set.add(n)).boxed().toList();
    }

}
