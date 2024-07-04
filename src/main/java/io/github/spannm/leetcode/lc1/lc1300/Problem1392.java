package io.github.spannm.leetcode.lc1.lc1300;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem1392 extends LeetcodeProblem {

    String longestPrefix(String _s) {
        int times = 2;
        long prefixHash = 0;
        long suffixHash = 0;
        long multiplier = 1;
        long len = 0;
        long mod = 1000000007;
        for (int i = 0; i < _s.length() - 1; i++) {
            prefixHash = (prefixHash * times + _s.charAt(i)) % mod;
            suffixHash = (multiplier * _s.charAt(_s.length() - i - 1) + suffixHash) % mod;
            if (prefixHash == suffixHash) {
                len = i + 1;
            }
            multiplier = multiplier * times % mod;
        }
        return _s.substring(0, (int) len);
    }

}
