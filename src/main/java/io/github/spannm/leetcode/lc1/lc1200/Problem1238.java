package io.github.spannm.leetcode.lc1.lc1200;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.ArrayList;
import java.util.List;

/**
 * 1238. Circular Permutation in Binary Representation.
 */
class Problem1238 extends LeetcodeProblem {

    List<Integer> circularPermutation(int _n, int _start) {
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < 1 << _n; i++) {
            ans.add(i ^ i >> 1 ^ _start);
        }
        return ans;
    }

}
