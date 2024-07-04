package io.github.spannm.leetcode.lc0.lc0000;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/scramble-string/">87. Scramble String</a>.
 */
class Problem0087 extends LeetcodeProblem {

    private final Map<String, Boolean> cache = new HashMap<>();

    boolean isScramble(String _str1, String _str2) {
        final int len1 = _str1.length();
        final int len2 = _str2.length();

        if (len1 != len2) {
            return false;
        } else if (_str1.equals(_str2)) {
            return true;
        } else if (len1 == 1) {
            return false;
        }

        final String key = _str1 + " " + _str2;

        if (cache.containsKey(key)) {
            return cache.get(key);
        }

        for (int i = 1; i < len1; i++) {
            if (isScramble(_str1.substring(0, i), _str2.substring(0, i)) // without swap
                && isScramble(_str1.substring(i), _str2.substring(i))
                ||
                isScramble(_str1.substring(0, i), _str2.substring(len1 - i)) // with swap
                    && isScramble(_str1.substring(i), _str2.substring(0, len1 - i))) {
                cache.put(key, true);
                return true;
            }
        }
        cache.put(key, false);
        return false;
    }

}
