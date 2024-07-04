package io.github.spannm.leetcode.lc0.lc0400;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * <a href="https://leetcode.com/problems/strong-password-checker/">420. Strong Password Checker</a>.
 */
class Problem0420 extends LeetcodeProblem {

    int strongPasswordChecker(String _password) {
        final char[] carr = _password.toCharArray();
        final int len = carr.length;
        final int[] arr = new int[len];

        int res = 0;
        int missingLcase = 1;
        int missingUcase = 1;
        int missingDigit = 1;

        for (int i = 0; i < len;) {
            if (Character.isLowerCase(carr[i])) {
                missingLcase = 0;
            } else if (Character.isUpperCase(carr[i])) {
                missingUcase = 0;
            } else if (Character.isDigit(carr[i])) {
                missingDigit = 0;
            }

            int j = i;
            while (i < len && carr[i] == carr[j]) {
                i++;
            }
            arr[j] = i - j;
        }

        int totalMissing = missingLcase + missingUcase + missingDigit;

        if (len < 6) {
            res += totalMissing + Math.max(0, 6 - (len + totalMissing));

        } else {
            int overLen = Math.max(len - 20, 0);
            int leftOver = 0;
            res += overLen;

            for (int k = 1; k < 3; k++) {
                for (int i = 0; i < len && overLen > 0; i++) {
                    if (arr[i] < 3 || arr[i] % 3 != k - 1) {
                        continue;
                    }
                    arr[i] -= Math.min(overLen, k);
                    overLen -= k;
                }
            }

            for (int i = 0; i < len; i++) {
                if (arr[i] >= 3 && overLen > 0) {
                    int need = arr[i] - 2;
                    arr[i] -= overLen;
                    overLen -= need;
                }

                if (arr[i] >= 3) {
                    leftOver += arr[i] / 3;
                }
            }

            res += Math.max(totalMissing, leftOver);
        }

        return res;
    }

}
