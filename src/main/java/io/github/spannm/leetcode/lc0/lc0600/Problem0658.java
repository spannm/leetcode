package io.github.spannm.leetcode.lc0.lc0600;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Arrays;
import java.util.List;

/**
 * 658. Find K Closest Elements.
 */
class Problem0658 extends LeetcodeProblem {

    List<Integer> findClosestElements(int[] _arr, int _k, int _x) {
        return Arrays.stream(_arr)
            .boxed()
            .sorted((a, b) -> {
                int v = Math.abs(a - _x) - Math.abs(b - _x);
                return v == 0 ? a - b : v;
            })
            .toList().subList(0, _k).stream().sorted().toList();
    }

}
