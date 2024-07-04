package io.github.spannm.leetcode.lc0.lc0100;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/compare-version-numbers/">165. Compare Version Numbers</a>.
 */
class Problem0165 extends LeetcodeProblem {

    int compareVersion(String _ver1, String _ver2) {
        if (_ver1.equals(_ver2)) {
            return 0;
        }

        int[] v1 = Arrays.stream(_ver1.split("\\.")).mapToInt(Integer::parseInt).toArray();
        int[] v2 = Arrays.stream(_ver2.split("\\.")).mapToInt(Integer::parseInt).toArray();
        int v1len = v1.length;
        int v2len = v2.length;

        int len = Math.max(v1len, v2len);

        for (int i = 0; i < len; i++) {
            if (v1len == i) {
                while (i < len) {
                    if (v2[i] > 0) {
                        return -1;
                    }
                    i++;
                }
            } else if (v2len == i) {
                while (i < len) {
                    if (v1[i] > 0) {
                        return 1;
                    }
                    i++;
                }
            } else if (v1[i] > v2[i]) {
                return 1;
            } else if (v2[i] > v1[i]) {
                return -1;
            }
        }
        return 0;
    }

}
