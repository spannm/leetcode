package io.github.spannm.leetcode.lc0.lc0800;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

class Problem0870 extends LeetcodeProblem {

    int[] advantageCount(int[] _a, int[] _b) {
        int[] result = new int[_a.length];
        Arrays.sort(_a);
        boolean[] used = new boolean[_a.length];
        for (int i = 0; i < _a.length; i++) {
            result[i] = findSmallestAdvantage(_a, used, _b[i]);
        }
        List<Integer> unused = new ArrayList<>();
        for (int i = 0; i < _a.length; i++) {
            if (!used[i]) {
                unused.add(_a[i]);
            }
        }
        Iterator<Integer> iterator = unused.iterator();
        for (int i = 0; i < _a.length; i++) {
            if (result[i] == -1) {
                result[i] = iterator.next();
            }
        }
        return result;
    }

    private int findSmallestAdvantage(int[] _arr, boolean[] _used, int _target) {
        for (int i = 0; i < _arr.length; i++) {
            if (!_used[i] && _arr[i] > _target) {
                _used[i] = true;
                return _arr[i];
            }
        }
        return -1;
    }

}
