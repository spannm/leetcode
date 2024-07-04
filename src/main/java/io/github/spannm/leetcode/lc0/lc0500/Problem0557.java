package io.github.spannm.leetcode.lc0.lc0500;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * <a href="https://leetcode.com/problems/reverse-words-in-a-string-iii/">557. Reverse Words in a String III</a>.
 */
class Problem0557 extends LeetcodeProblem {

    String reverseWords(String _str) {

        final int len = _str.length();
        if (len < 2) {
            return _str;
        }

        final char[] arr = _str.toCharArray();

        int lastWs = -1;
        for (int ws = _str.indexOf(' '); ws < len; ws = _str.substring(lastWs + 1).indexOf(' ')) {
            int from = lastWs + 1; // inclusive
            int to = ws < 0 ? len : from + ws; // exclusive
            reverse(arr, from, to - 1); // reverse word
            if (to == len) {
                break;
            }
            lastWs = to;
        }

        String result = new String(arr);
        return result;
    }

    static void reverse(char[] _chars, int _from, int _to) {
        for (; _from < _to; _from++, _to--) {
            char leftChar = _chars[_from];
            _chars[_from] = _chars[_to];
            _chars[_to] = leftChar;
        }
    }

}
