package io.github.spannm.leetcode.lc0.lc0300;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Problem0315 extends LeetcodeProblem {

    List<Integer> countSmaller(int[] _nums) {
        int len = _nums.length;
        List<Integer> result = new ArrayList<>(Collections.nCopies(len, 0));
        List<Integer> list = new ArrayList<>();

        for (int i = len - 1; i >= 0; i--) {
            result.set(i, binarySearch(_nums[i], 0, list, list.size()));
        }
        return result;
    }

    static int binarySearch(int _num, int _s, List<Integer> _list, int _size) {
        int mid = _s + (_size - _s) / 2;
        if (_s >= _size) {
            _list.add(mid, _num);
            return mid;
        }
        if (_num <= _list.get(mid)) {
            return binarySearch(_num, _s, _list, mid);
        } else {
            return binarySearch(_num, mid + 1, _list, _size);
        }
    }

}
