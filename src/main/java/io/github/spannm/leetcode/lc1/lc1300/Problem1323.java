package io.github.spannm.leetcode.lc1.lc1300;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.stream.IntStream;

/**
 * 1323. Maximum 69 Number
 * <p>
 * Given a positive integer num consisting only of digits 6 and 9. Return the maximum number you can get by changing at
 * most one digit (6 becomes 9, and 9 becomes 6).
 * <p>
 * Example 1: Input: num = 9669 Output: 9969 Explanation: Changing the first digit results in 6669. Changing the second
 * digit results in 9969. Changing the third digit results in 9699. Changing the fourth digit results in 9666. The
 * maximum number is 9969.
 * <p>
 * Example 2: Input: num = 9996 Output: 9999 Explanation: Changing the last digit 6 to 9 results in the maximum number.
 * <p>
 * Example 3: Input: num = 9999 Output: 9999 Explanation: It is better not to apply any change.
 * <p>
 * Constraints: 1 <= num <= 10^4 num's digits are 6 or 9.
 */
class Problem1323 extends LeetcodeProblem {

    int maximum69Number(int _num) {
        char[] chars = Integer.toString(_num).toCharArray();
        IntStream.range(0, chars.length).filter(i -> chars[i] == '6').findFirst().ifPresent(i -> chars[i] = '9');
        return Integer.parseInt(new String(chars));
    }

}
