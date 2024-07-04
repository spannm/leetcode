package io.github.spannm.leetcode.lc1.lc1600;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.List;
import java.util.stream.IntStream;

/**
 * <a href="https://leetcode.com/problems/arithmetic-subarrays/">1630. Arithmetic Subarrays</a>.
 */
class Problem1630 extends LeetcodeProblem {

    List<Boolean> checkArithmeticSubarrays(int[] _nums, int[] _l, int[] _r) {
        return IntStream.range(0, _l.length).mapToObj(i -> isArithmetic(_nums, _l[i], _r[i])).toList();
    }

    static boolean isArithmetic(int[] _nums, int _start, int _end) {
        int[] arr = IntStream.rangeClosed(_start, _end).map(i -> _nums[i]).sorted().toArray();

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] - arr[i - 1] != arr[1] - arr[0]) {
                return false;
            }
        }
        return true;
    }

}
