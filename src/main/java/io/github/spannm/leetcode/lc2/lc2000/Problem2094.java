package io.github.spannm.leetcode.lc2.lc2000;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.*;

class Problem2094 extends LeetcodeProblem {

    int[] findEvenNumbers(int[] _digits) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < _digits.length; i++) {
            int number = _digits[i] * 100;
            if (_digits[i] != 0) {
                for (int j = 0; j < _digits.length; j++) {
                    if (j != i) {
                        number += _digits[j] * 10;
                        for (int k = 0; k < _digits.length; k++) {
                            if (k != i && k != j && _digits[k] % 2 == 0) {
                                number += _digits[k];
                                set.add(number);
                                number -= _digits[k];
                            }
                        }
                        number -= _digits[j] * 10;
                    }
                }
            }
        }
        List<Integer> list = new ArrayList<>(set);
        Collections.sort(list);
        int[] ans = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            ans[i] = list.get(i);
        }
        return ans;
    }

}
