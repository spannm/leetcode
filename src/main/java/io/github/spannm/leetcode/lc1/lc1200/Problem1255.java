package io.github.spannm.leetcode.lc1.lc1200;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 1255. Maximum Score Words Formed by Letters.
 */
class Problem1255 extends LeetcodeProblem {

    int maxScoreWords(String[] _words, char[] _letters, int[] _score) {
        int[] cnt = new int[26];
        for (char letter : _letters) {
            cnt[letter - 'a']++;
        }
        int len = _words.length;
        int result = 0;
        for (int i = 0; i < 1 << len; i++) {
            int[] cur = new int[26];
            for (int j = 0; j < len; j++) {
                if ((i >> j & 1) == 1) {
                    for (int k = 0; k < _words[j].length(); k++) {
                        cur[_words[j].charAt(k) - 'a']++;
                    }
                }
            }
            boolean ok = true;
            int t = 0;
            for (int j = 0; j < 26; j++) {
                if (cur[j] > cnt[j]) {
                    ok = false;
                    break;
                }
                t += cur[j] * _score[j];
            }
            if (ok && result < t) {
                result = t;
            }
        }
        return result;
    }

}
