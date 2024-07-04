package io.github.spannm.leetcode.lc2.lc2400;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem2433 extends LeetcodeProblem {

    int[] findArray(int[] _pref) {
        final int len = _pref.length;
        int[] arr = new int[len];
        arr[0] = _pref[0];
        int arrResult = arr[0];
        for (int i = 1; i < len; i++) {
            arr[i] = arrResult ^ _pref[i];
            arrResult ^= arr[i];
        }
        return arr;
    }

}
