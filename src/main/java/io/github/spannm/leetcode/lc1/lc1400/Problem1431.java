package io.github.spannm.leetcode.lc1.lc1400;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Arrays;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/kids-with-the-greatest-number-of-candies/">1431. Kids With the Greatest Number
 * of Candies</a>.
 */
class Problem1431 extends LeetcodeProblem {

    static List<Boolean> kidsWithCandies(int[] _candies, int _extraCandies) {
        int max = Arrays.stream(_candies).max().orElse(-1) - _extraCandies;
        return Arrays.stream(_candies).mapToObj(i -> i >= max).toList();
    }

}
