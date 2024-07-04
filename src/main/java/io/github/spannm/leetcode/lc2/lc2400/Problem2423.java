package io.github.spannm.leetcode.lc2.lc2400;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 2423. Remove Letter To Equalize Frequency.
 */
class Problem2423 extends LeetcodeProblem {

    boolean equalFrequency(String word) {
        int[] cnt = new int[26];
        for (int i = 0; i < word.length(); i++) {
            ++cnt[word.charAt(i) - 'a'];
        }
        for (int i = 0; i < 26; i++) {
            if (cnt[i] > 0) {
                cnt[i]--;
                int x = 0;
                boolean ok = true;
                for (int v : cnt) {
                    if (v == 0) {
                        continue;
                    }
                    if (x > 0 && v != x) {
                        ok = false;
                        break;
                    }
                    x = v;
                }
                if (ok) {
                    return true;
                }
                cnt[i]++;
            }
        }
        return false;
    }

}
