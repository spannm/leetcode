package io.github.spannm.leetcode.lc1.lc1300;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 1317. Convert Integer to the Sum of Two No-Zero Integers
 * <p>
 * Given an integer n. No-Zero integer is a positive integer which doesn't contain any 0 in its decimal representation.
 * <p>
 * Return a list of two integers [A, B] where: A and B are No-Zero integers. A + B = n It's guarateed that there is at
 * least one valid solution. If there are many valid solutions you can return any of them.
 * <p>
 * Example 1: Input: n = 2 Output: [1,1] Explanation: A = 1, B = 1. A + B = n and both A and B don't contain any 0 in
 * their decimal representation.
 * <p>
 * Example 2: Input: n = 11 Output: [2,9]
 * <p>
 * Example 3: Input: n = 10000 Output: [1,9999]
 * <p>
 * Example 4: Input: n = 69 Output: [1,68]
 * <p>
 * Example 5: Input: n = 1010 Output: [11,999]
 * <p>
 * Constraints: 2 <= n <= 10^4
 */
class Problem1317 extends LeetcodeProblem {

    int[] getNoZeroIntegers(int _n) {
        int left = 1;
        int right = _n - 1;
        while (left <= right) {
            if (noZero(left) && noZero(right)) {
                return new int[] {left, right};
            } else {
                left++;
                right--;
            }
        }
        return null;
    }

    private boolean noZero(int _num) {
        while (_num != 0) {
            if (_num % 10 == 0) {
                return false;
            } else {
                _num /= 10;
            }
        }
        return true;
    }

}
