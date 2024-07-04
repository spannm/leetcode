package io.github.spannm.leetcode.lc1.lc1500;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem1528 extends LeetcodeProblem {

    String restoreString(String _s, int[] _indices) {
        char[] c = new char[_s.length()];
        for (int i = 0; i < _s.length(); i++) {
            int index = findIndex(_indices, i);
            c[i] = _s.charAt(index);
        }
        return new String(c);
    }

    private static int findIndex(int[] _indices, int _i) {
        for (int j = 0; j < _indices.length; j++) {
            if (_indices[j] == _i) {
                return j;
            }
        }
        return 0;
    }

}
