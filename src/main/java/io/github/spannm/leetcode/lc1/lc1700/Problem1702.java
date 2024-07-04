package io.github.spannm.leetcode.lc1.lc1700;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Arrays;

/**
 * 1702. Maximum Binary String After Change.
 */
class Problem1702 extends LeetcodeProblem {

    String maximumBinaryString(String binary) {
        int k = binary.indexOf('0');
        if (k == -1) {
            return binary;
        }
        int n = binary.length();
        for (int i = k + 1; i < n; i++) {
            if (binary.charAt(i) == '0') {
                k++;
            }
        }
        char[] ans = binary.toCharArray();
        Arrays.fill(ans, '1');
        ans[k] = '0';
        return String.valueOf(ans);
    }

}
