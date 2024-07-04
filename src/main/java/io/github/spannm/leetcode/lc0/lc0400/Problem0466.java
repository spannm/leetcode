package io.github.spannm.leetcode.lc0.lc0400;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem0466 extends LeetcodeProblem {

    int getMaxRepetitions(String _s1, int _n1, String _s2, int _n2) {
        char[] arr1 = _s1.toCharArray();
        char[] arr2 = _s2.toCharArray();
        int i = 0;
        int j = 0;
        int count1 = 0;
        int count2 = 0;
        while (count1 < _n1) {
            if (arr1[i] == arr2[j]) {
                j++;
                if (j == _s2.length()) {
                    j = 0;
                    count2++;
                }
            }
            i++;
            if (i == _s1.length()) {
                i = 0;
                count1++;
            }
        }
        return count2 / _n2;
    }

}
