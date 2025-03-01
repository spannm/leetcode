package io.github.spannm.leetcode.lc1.lc1300;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 1399. Count Largest Group
 * <p>
 * Given an integer n. Each number from 1 to n is grouped according to the sum of its digits. Return how many groups
 * have the largest size.
 * <p>
 * Example 1: Input: n = 13 Output: 4 Explanation: There are 9 groups in total, they are grouped according sum of its
 * digits of numbers from 1 to 13: [1,10], [2,11], [3,12], [4,13], [5], [6], [7], [8], [9]. There are 4 groups with
 * largest size.
 * <p>
 * Example 2: Input: n = 2 Output: 2 Explanation: There are 2 groups [1], [2] of size 1.
 * <p>
 * Example 3: Input: n = 15 Output: 6
 * <p>
 * Example 4: Input: n = 24 Output: 5
 * <p>
 * Constraints: 1 <= n <= 10^4
 */
class Problem1399 extends LeetcodeProblem {

    int countLargestGroup(int _n) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 1; i <= _n; i++) {
            int sumOfDigits = getSum(i);
            if (!map.containsKey(sumOfDigits)) {
                map.put(sumOfDigits, new ArrayList<>());
            }
            map.get(sumOfDigits).add(i);
        }
        int max = 0;
        for (int key : map.keySet()) {
            max = Math.max(max, map.get(key).size());
        }
        int count = 0;
        for (int key : map.keySet()) {
            if (map.get(key).size() == max) {
                count++;
            }
        }
        return count;
    }

    private int getSum(int _num) {
        int sum = 0;
        while (_num != 0) {
            sum += _num % 10;
            _num /= 10;
        }
        return sum;
    }

}
