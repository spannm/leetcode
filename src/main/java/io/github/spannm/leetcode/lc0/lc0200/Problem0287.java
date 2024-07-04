package io.github.spannm.leetcode.lc0.lc0200;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * <a href="https://leetcode.com/problems/find-the-duplicate-number/">287. Find the Duplicate Number</a>.
 */
class Problem0287 extends LeetcodeProblem {

    int findDuplicate(int[] _nums) {
        Set<Integer> set = new HashSet<>();
        return Arrays.stream(_nums).filter(i -> !set.add(i)).findFirst().orElse(-1);
    }

}
