package io.github.spannm.leetcode.lc2.lc2100;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem2156 extends LeetcodeProblem {

    String subStrHash(String _s, int _power, int _modulo, int _k, int _hashValue) {
        long weight = 1;
        for (int j = 0; j < _k - 1; j++) {

            weight = weight * _power % _modulo;
        }

        String result = "";

        int right = _s.length() - 1;

        long hash = 0;
        for (int i = _s.length() - 1; i >= 0; i--) {

            int val = _s.charAt(i) - 'a' + 1;

            hash = (hash * _power % _modulo + val) % _modulo;

            if (right - i + 1 == _k) {
                if (hash == _hashValue) {
                    result = _s.substring(i, right + 1);
                }
                hash = (hash + _modulo - (_s.charAt(right--) - 'a' + 1) * weight % _modulo) % _modulo;
            }
        }

        return result;
    }

}
