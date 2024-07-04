package io.github.spannm.leetcode.lc1.lc1300;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.ArrayList;
import java.util.List;

/**
 * 1390. Four Divisors
 * <p>
 * Given an integer array nums, return the sum of divisors of the integers in that array that have exactly four
 * divisors. If there is no such integer in the array, return 0.
 * <p>
 * Example 1: Input: nums = [21,4,7] Output: 32 Explanation: 21 has 4 divisors: 1, 3, 7, 21 4 has 3 divisors: 1, 2, 4 7
 * has 2 divisors: 1, 7 The answer is the sum of divisors of 21 only.
 * <p>
 * Constraints: 1 <= nums.length <= 10^4 1 <= nums[i] <= 10^5
 */
class Problem1390 extends LeetcodeProblem {

    int sumFourDivisors(int[] _nums) {
        int sum = 0;
        for (int num : _nums) {
            List<Integer> divisors = getDivisors(num);
            if (divisors.size() == 4) {
                for (int div : divisors) {
                    sum += div;
                }
            }
        }
        return sum;
    }

    private List<Integer> getDivisors(int _num) {
        List<Integer> divisors = new ArrayList<>();
        for (int i = 1; i <= Math.sqrt(_num); i++) {
            if (_num % i == 0) {
                divisors.add(i);
                if (_num / i != i) {
                    divisors.add(_num / i);
                }
            }
        }
        return divisors;
    }

}
