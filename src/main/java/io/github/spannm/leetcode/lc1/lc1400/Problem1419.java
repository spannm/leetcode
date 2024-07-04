package io.github.spannm.leetcode.lc1.lc1400;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 1419. Minimum Number of Frogs Croaking.
 */
class Problem1419 extends LeetcodeProblem {

    int minNumberOfFrogs(String croakOfFrogs) {
        int n = croakOfFrogs.length();
        if (n % 5 != 0) {
            return -1;
        }
        int[] idx = new int[26];
        String s = "croak";
        for (int i = 0; i < 5; i++) {
            idx[s.charAt(i) - 'a'] = i;
        }
        int[] cnt = new int[5];
        int ans = 0;
        int x = 0;
        for (int k = 0; k < n; k++) {
            int i = idx[croakOfFrogs.charAt(k) - 'a'];
            cnt[i]++;
            if (i == 0) {
                ans = Math.max(ans, x++);
            } else {
                if (--cnt[i - 1] < 0) {
                    return -1;
                }
                if (i == 4) {
                    x--;
                }
            }
        }
        return x > 0 ? -1 : ans;
    }

}
