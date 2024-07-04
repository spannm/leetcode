package io.github.spannm.leetcode.lc0.lc0900;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.ArrayList;
import java.util.List;

/**
 * 969. Pancake Sorting.
 */
class Problem0969 extends LeetcodeProblem {

    List<Integer> pancakeSort(int[] _arr) {
        int n = _arr.length;
        List<Integer> ans = new ArrayList<>();
        for (int i = n - 1; i > 0; i--) {
            int j = i;
            while (j > 0 && _arr[j] != i + 1) {
                j--;
            }
            if (j < i) {
                if (j > 0) {
                    ans.add(j + 1);
                    reverse(_arr, j);
                }
                ans.add(i + 1);
                reverse(_arr, i);
            }
        }
        return ans;
    }

    private void reverse(int[] _arr, int _j) {
        for (int i = 0; i < _j; i++, _j--) {
            int t = _arr[i];
            _arr[i] = _arr[_j];
            _arr[_j] = t;
        }
    }

}
