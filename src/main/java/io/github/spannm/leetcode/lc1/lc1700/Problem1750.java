package io.github.spannm.leetcode.lc1.lc1700;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem1750 extends LeetcodeProblem {

    int minimumLength(String _s) {
        char[] arr = _s.toCharArray();
        int i = 0;
        int j = _s.length() - 1;
        if (arr[i] == arr[j]) {
            while (i < j && arr[i] == arr[j]) {
                char c = arr[i];
                i++;
                while (c == arr[i] && i < j) {
                    i++;
                }
                j--;
                while (c == arr[j] && i < j) {
                    j--;
                }
            }
        }
        return i <= j ? _s.substring(i, j).length() + 1 : 0;
    }

}
