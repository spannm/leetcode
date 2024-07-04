package io.github.spannm.leetcode.lc2.lc2000;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem2063 extends LeetcodeProblem {

    long countVowels(String _word) {
        long ans = 0;
        for (int i = 0; i < _word.length(); i++) {
            if (isVowel(_word.charAt(i))) {
                long left = i;
                long right = _word.length() - left - 1;
                ans += (left + 1) * (right + 1);
            }
        }
        return ans;
    }

    private static boolean isVowel(char _ch) {
        return _ch == 'a' || _ch == 'e' || _ch == 'i' || _ch == 'o' || _ch == 'u';
    }

}
