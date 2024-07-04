package io.github.spannm.leetcode.lc1.lc1700;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem1720 extends LeetcodeProblem {

    int[] decode(int[] _encoded, int _first) {
        int[] arr = new int[_encoded.length + 1];
        arr[0] = _first;
        for (int i = 0; i < _encoded.length; i++) {
            arr[i + 1] = _encoded[i] ^ arr[i];
        }
        return arr;
    }

}
