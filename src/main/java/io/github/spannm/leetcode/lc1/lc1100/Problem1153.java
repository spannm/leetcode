package io.github.spannm.leetcode.lc1.lc1100;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 1153. String Transforms Into Another String.
 */
class Problem1153 extends LeetcodeProblem {

    boolean canConvert(String _str1, String _str2) {
        if (_str1.equals(_str2)) {
            return true;
        }
        int m = 0;
        int[] cnt = new int[26];
        int n = _str1.length();
        for (int i = 0; i < n; i++) {
            if (++cnt[_str2.charAt(i) - 'a'] == 1) {
                m++;
            }
        }
        if (m == 26) {
            return false;
        }
        int[] d = new int[26];
        for (int i = 0; i < n; i++) {
            int a = _str1.charAt(i) - 'a';
            int b = _str2.charAt(i) - 'a';
            if (d[a] == 0) {
                d[a] = b + 1;
            } else if (d[a] != b + 1) {
                return false;
            }
        }
        return true;
    }

}
